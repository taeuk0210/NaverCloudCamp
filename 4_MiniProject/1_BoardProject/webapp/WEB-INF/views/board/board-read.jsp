<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover"><title>회원가입</title>
    <link rel="stylesheet" href="/css/base-style.css">
    <link rel="stylesheet" href="/css/board-read.css">
    <script type="text/javascript" src="/js/functions.js"></script>
</head>
<body>
 	<c:choose>
        <c:when test="${sessionScope.isLoggedIn == true}">
            <jsp:include page="/WEB-INF/views/main/headerOUT.jsp" flush="true"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="/WEB-INF/views/main/headerIN.jsp" flush="true"/>
        </c:otherwise>
    </c:choose>

    <div class="container">
		<c:choose>
	        <c:when test="${sessionScope.isLoggedIn == true}">
	            <jsp:include page="/WEB-INF/views/main/side.jsp" flush="true"/>
	        </c:when>
    	</c:choose>
	    
        <div class="content">
            <h2>게시글 확인</h2>
            <div class="reg-btn">
            	<c:if  test="${sessionScope.userId.equals(content.contentAuthor)}">
	                <button onclick="location.href='/board/update?contentId=${content.contentId}'">게시글 수정</button>
	                <button onclick="location.href='/board/delete?contentId=${content.contentId}'">게시글 삭제</button> 
                </c:if>
            </div>
            <div class="content-frm">
                <div id="content-title">
                	${content.contentTitle}
                </div>
                <div id="content-info">
                    <div id="content-author">${content.contentAuthor}</div>
                    <div id="add-date">작성일 : ${content.addDate}</div>
                    <div id="edit-date">수정일 : ${content.editDate}</div>
                </div>
                <div id="content-main">
					${content.contentMain}
                </div>

            </div>
            
            <div class="comment-frm">
                <div id="comment-reg">
                    <form action="/comment/write?contentId=${content.contentId}" method="post">
                        <textarea placeholder=" 댓글을 남겨주세요." name="commentMain"></textarea>
                        <input type="hidden" name="commentAuthor" value="${userId }"/>
                        <input type="hidden" name="contentId" value="${content.contentId }"/>
                        <button type="submit">댓글 입력</button>
                    </form>
                </div>
                <div id="comment-view">
                	<c:if test="${comments.size()==0 }">
                		댓글이 없어요. T^T 댓글을 작성해주세요.
                	</c:if>
                	
                	<c:if test="${comments.size()!=0}">
	                	<c:forEach var="i" begin="0" end="${comments.size()-1}" step="1">
		                	
		                	<div class="comment">
			                	
			                	<div class="comment-author">
		                            ${comments[i].commentAuthor}
		                        </div>
		                        
		                        <div class="comment-main">
		                            ${comments[i].commentMain}
		                        </div>
		                        
		                        <div class="comment_fn">
	                                <button onclick="showButtonAdd(${i})">댓글 작성</button>
	                                <c:if  test="${sessionScope.userId.equals(comments[i].commentAuthor)}">
		                                <button onclick="showButtonEdit(${i})">댓글 수정</button>
		                                <form action="/comment/delete?commentId=${comments[i].commentId}" method="post">
		                                	<button type="submit">댓글 삭제</button>
			                    			<input type="hidden" name="contentId" value="${content.contentId }"/>
	                       				</form>
                       				</c:if>
                       			</div>
                       			
                       		</div>
                       		
                       		<div id="comment-reg-add${i}" class="comment-reg-hidden">
			                    <form action="/comment/cwrite?contentId=${content.contentId }" method="post">
			                        <textarea placeholder=" 댓글을 입력하세요" name="commentMain"></textarea>
                       				<input type="hidden" name="commentAuthor" value="${sessionScope.userId }"/>
                       				<input type="hidden" name="parentId" value="${comments[i].commentId }"/>
			                    	<input type="hidden" name="contentId" value="${content.contentId }"/>
			                        <button type="submit">댓글 입력</button>
			                    </form>
		                	</div>
		                	
                       		<div id="comment-reg-edit${i}" class="comment-reg-hidden">
			                    <form action="/comment/update?commentId=${comments[i].commentId}" method="post">
			                        <textarea placeholder="${comments[i].commentMain }" name="commentMain"></textarea>
			                        <input type="hidden" name="commentAuthor" value="${sessionScope.userId }"/>
			                    	<input type="hidden" name="contentId" value="${content.contentId }"/>
			                    	<button type="submit">댓글 입력</button>
			                    </form>
		                	</div>
      
	                    </c:forEach>
                    </c:if>
	                
                </div>
            </div>
            <div class="page-frm">
            	<c:if test="${prevContent!=null}">
	                <div class="prev-next">
	                    <a href="/board/read?contentId=${prevContent.contentId}">이전글 : ${prevContent.contentTitle}</a>
	                </div>
                </c:if>
                <c:if test="${nextContent!=null}">
	                <div class="prev-next">
	                    <a href="/board/read?contentId=${nextContent.contentId}">다음글 : ${nextContent.contentTitle}</a>
	                </div>
                </c:if>
            </div>
        </div>
    </div>

	<jsp:include page="/WEB-INF/views/main/footer.jsp" flush="true"/>
</body>
</html>