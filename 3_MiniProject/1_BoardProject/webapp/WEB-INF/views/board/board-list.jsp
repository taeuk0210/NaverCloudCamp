<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="com.myedu.myapp.model.ResultContent" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
		<title>회원가입</title>
	    <link rel="stylesheet" href="/css/base-style.css">
	    <link rel="stylesheet" href="/css/board-list.css">
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
            <jsp:include page="/WEB-INF/views//main/side.jsp" flush="true"/>
        </c:when>
    	</c:choose>
	    
	        <div class="content">
	            <h2>게시글 목록</h2>
	            <form action="/board" method="post" id="search">
	                <div class="query-frm">
	                    <div>검색 기준</div>
	                    <select name="querySelect" id="querySelect">
	                    	<c:if test="${query.querySelect.equals('all')}">
	                    		<option value="all" selected>전체</option>
	                    		<option value="content_title">제목</option>
	                    		<option value="content_author">작성자</option>
	                    		<option value="content_main">내용</option>
	                    	</c:if>
	                        <c:if test="${query.querySelect.equals('content_title')}">
	                    		<option value="all" >전체</option>
	                    		<option value="content_title" selected>제목</option>
	                    		<option value="content_author">작성자</option>
	                    		<option value="content_main">내용</option>
	                    	</c:if>
	                    	<c:if test="${query.querySelect.equals('content_author')}">
	                    		<option value="all" >전체</option>
	                    		<option value="content_title">제목</option>
	                    		<option value="content_author" selected>작성자</option>
	                    		<option value="content_main">내용</option>
	                    	</c:if>
	                    	<c:if test="${query.querySelect.equals('content_main')}">
	                    		<option value="all" >전체</option>
	                    		<option value="content_title">제목</option>
	                    		<option value="content_author">작성자</option>
	                    		<option value="content_main" selected>내용</option>
	                    	</c:if>

	                    </select>
	                    <c:if test="${query.queryWord==null }">
	                    	<input type="search" placeholder="검색어를 입력하세요." name="queryWord"/>
	                    </c:if>
	                    <c:if test="${query.queryWord!=null }">
	                    	<input type="search" value="${query.queryWord}" name="queryWord"/>
	                    </c:if>
	                    <button type="submit">검색</button>
	                </div>

	                <div class="order-frm">
	                    <div>정렬 기준</div>
	                    <select name="orderSelect" id="orderSelect">
	                    	<c:if test="${query.orderSelect.equals('add_date desc')}">		                    
		                        <option value="add_date desc" selected>최신순</option>
		                        <option value="add_date asc">오래된순</option>
		                        <option value="content_view desc">조회순</option>
	                    	</c:if>
	                    	<c:if test="${query.orderSelect.equals('add_date asc')}">		                    
		                        <option value="add_date desc" >최신순</option>
		                        <option value="add_date asc" selected>오래된순</option>
		                        <option value="content_view desc">조회순</option>
	                    	</c:if>
	                    	<c:if test="${query.orderSelect.equals('content_view desc')}">		                    
		                        <option value="add_date desc" >최신순</option>
		                        <option value="add_date asc">오래된순</option>
		                        <option value="content_view desc" selected>조회순</option>
	                    	</c:if>
	                    </select>
	                </div>
	            </form>
	            <table class="content-list">
	                <thead>
	                    <tr>
	                        <th>순번</th>
	                        <th>제목</th>
	                        <th>작성자</th>
	                        <th>작성일</th>
	                        <th>조회수</th>
	                    </tr>
	                </thead>
					
	                <tbody>
	                	<c:if test="${resultContent.contents.size()==0}">
	                		<tr><td rowspan="5">검색 결과가 없습니다 T^T</td></tr>
	                	</c:if>
	                	
	                	<c:if test="${resultContent.contents.size()!=0}">
		                    <c:forEach var="content" items="${resultContent.contents}" >
			                    <tr>
			                        <td>${content.contentId}</td>
			                        <td>
			                            <a href="/board/read?contentId=${content.contentId}">
			                            	${content.contentTitle} (${commentNumbers[content.contentId]})
			                            </a>
			                        </td>
			                        <td>${content.contentAuthor}</td>
			                        <td>${content.addDate}</td>
			                        <td>${content.contentView}</td>
			                    </tr>
		                    </c:forEach>
	                    </c:if>
	                </tbody>
	 
	            </table>

	            <div class="content-reg">
	                <button>
	                	<a href="/board/write">글쓰기</a>
           			</button>
	            </div>
	
	            <div class="page-frm">
	            	<c:choose>
	            		<c:when test="${query.page-5 < 1}">
                            <div class="prev-next">
		                  	    <a href="/board?page=${1}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}"><<</a>
		                	</div>
                       </c:when>
                       <c:otherwise>
                       		<div class="prev-next">
		                  	    <a href="/board?page=${query.page-5}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}"><<</a>
		                	</div>
                       </c:otherwise>
                   </c:choose>
	                
	            	<c:choose>
	            		<c:when test="${query.page-1 >= 1}">
                            <div class="prev-next">
			                    <a href="/board?page=${query.page-1}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}"><</a>
			                </div>
                       </c:when>
                       <c:otherwise>
                       		<div class="prev-next">
		                  	    <a href="/board?page=${1}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}"><</a>
		                	</div>
                       </c:otherwise>
                   </c:choose>
	                <c:forEach var="i" begin="${resultContent.startPage }" end="${resultContent.endPage}" step="1">
	                	<c:if test="${query.page==i }">
		                	<div class="current">
								<a href="/board?page=${i}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}">${i}</a>
			                </div>
		                </c:if>
		                <c:if test="${query.page!=i }">
		                	<div class="prev-next">
			                    <a href="/board?page=${i}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}">${i}</a>
			                </div>
		                </c:if>
	                </c:forEach>
	                <c:choose>
	            		<c:when test="${query.page+1 < resultContent.totalPage}">
                            <div class="prev-next">
			                    <a href="/board?page=${query.page+1}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}">></a>
			                </div>
                       </c:when>
                       <c:otherwise>
                       		<div class="prev-next">
		                  	    <a href="/board?page=${resultContent.totalPage}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}">></a>
		                	</div>
                       </c:otherwise>
                   </c:choose>
	                
	                <c:choose>
	            		<c:when test="${query.page+5 > resultContent.totalPage}">
                            <div class="prev-next">
		                  	    <a href="/board?page=${resultContent.totalPage}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}">>></a>
		                	</div>
                       </c:when>
                       <c:otherwise>
                       		<div class="prev-next">
		                  	    <a href="/board?page=${query.page+5}&querySelect=${query.querySelect}&orderSelect=${query.orderSelect}&queryWord=${query.queryWord}">>></a>
		                	</div>
                       </c:otherwise>
                   </c:choose>
	            </div>
	        </div>
	    </div>

	<jsp:include page="/WEB-INF/views/main/footer.jsp" flush="true"/>
</body>
</html>