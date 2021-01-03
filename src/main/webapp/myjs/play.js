//当点击搜索按钮后，浏览器改变url的值，然后search.html自动执行一次异步请求搜索
document.querySelector(".search-submit").onclick = function () {
    location.href = "search.html?keyWord="+document.querySelector(".keyWord").value;
}
