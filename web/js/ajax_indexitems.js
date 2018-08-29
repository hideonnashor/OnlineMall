var itemCategory = "图书、音像、电子书刊";
$(document).ready(function(){
	// 商品侧边栏点击
	$(".itemtype").click(function(){
		itemCategory = $(this).text();
		$(".pagebutton1").text(1);
		$(".pagebutton2").text(2);
		$(".pagebutton3").text(3);
		$(".pagebutton4").text(4);
		$(".pagebutton5").text(5);
		getItemByType(itemCategory,1);
	});
	// 页数点击
	$(".pagebutton1,.pagebutton2,.pagebutton3,.pagebutton4,.pagebutton5").click(function(){
		var page = eval($(this).text());
		if (page>=3) {
			$(".pagebutton1").text(page-2);
			$(".pagebutton2").text(page-1);
			$(".pagebutton3").text(page);
			$(".pagebutton4").text(page+1);
			$(".pagebutton5").text(page+2);
		}else {
			$(".pagebutton1").text(1);
			$(".pagebutton2").text(2);
			$(".pagebutton3").text(3);
			$(".pagebutton4").text(4);
			$(".pagebutton5").text(5);
		}
		getItemByType(itemCategory,page);
	});
});

function getItemByType(itemCate,page) {
	// var settings = {
	// 	"async": false,
	// 	"crossDomain": true,
	// 	"url": "http://localhost:8080/OnlineMall/item/showbytype?itemcate="+itemCate+"&page="+page,
	// 	"method": "GET",
	// 	"headers": {
	// 		"Cache-Control": "no-cache"
	// 	}
	// }

	// $.ajax(settings).done(function (response) {
	// 	console.log(response);
	// });
	$.getJSON("http://localhost:8080/OnlineMall/item/showbytype?itemcate="+itemCategory+"&page="+page,function(data){
		var mbody = data.Mbody;

		$("#items").html("");
		for (var i = 0; i < mbody.length; i++) {
			var itemName = mbody[i].itemName;
			var itemIntro = mbody[i].itemIntro;
			var itemImage = mbody[i].itemImage;
			
			var element = 	    			
				'<div class="product-item col-sm-3">'+
					'<a href="#">'+
    					'<img src='+itemImage+' class="img-responsive" style="height:100px;">'+
    				'</a>'+
    				'<h2>'+
    					'<a href="#">'+itemName+'</a>'+
    				'</h2>'+
    				'<p style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">'+itemIntro+'</p>'+
    				'<a href="#" class="btn btn-default btn-xs pull-right">'+
    					'<i>详情</i>'+
    				'</a>'+
    				'<a href="#" class="btn btn-default btn-xs pull-right">'+
    					'<i>加入购物车</i>'+
    				'</a>'+
    			'</div>';

			$("#items").append(element);
		}
	});
}