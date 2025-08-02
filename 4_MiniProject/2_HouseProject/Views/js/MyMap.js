const script = document.createElement("script");
script.src = "http://dapi.kakao.com/v2/maps/sdk.js?appkey=709a7d94d6b0f541d05da5745b287b18&autoload=false";
document.head.appendChild(script);
script.onload = () => {
    kakao.maps.load(() => {
        const node = document.getElementById('map'); // 지도를 표시할 div
        const center = new kakao.maps.LatLng(37.50802, 127.062835);
        const options = {
            center,
            level: 3
        };
        const map = new kakao.maps.Map(node, options);
    });
};