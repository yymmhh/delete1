
window.onscroll = function(){ //绑定scroll事件
	  var t = document.documentElement.scrollTop || document.body.scrollTop; 
	  // $("#wl_goshop_title").html(t);
//	  console.log(t);

		$(".nav-stacked").css("margin-top",10);
		//$(".nav-stacked").css("margin-top",10);
	  if(t>=200){
        $(".items").show();
	  	$("#wl_nav").addClass("wl_goshop_top");
	  	$("ul.nav-pills").addClass("wl_goshop_leftstop");
	  	$("#wl_goshop_nav").addClass("wl_goshop_leftStopTop");
	  	$("#wl_goshop_content").addClass("wl_goshop_contentStop");
	  	//$("#wl_goshop_nav li").addClass("wltt")
	  }
	  if(t<200){
        $("#wl_goshop_tiao").hide();
	  	$("#wl_nav").removeClass("wl_goshop_top");	
	  	$("ul.nav-pills").removeClass("wl_goshop_leftstop");	
	  	$("#wl_goshop_nav").removeClass("wl_goshop_leftStopTop");
	  	$("#wl_goshop_content").removeClass("wl_goshop_contentStop");
	  }
}
	
	
	  $(function(){
        var $toast = $('#toast');
        $('#showToast').on('click', function(){
            
            if ($toast.css('display') != 'none') return;

            $toast.fadeIn(100);
            setTimeout(function () {
                $toast.fadeOut(100);
            }, 2000);
        });
    });