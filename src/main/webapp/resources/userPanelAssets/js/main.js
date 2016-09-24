jQuery(function($) {
    

   
 
    /*
	 * ====================================== Menu
	 * ======================================
	 */
    
    $("#sticktop").sticky({
        topSpacing: 0
    });
    $(window).on('resize load', function() {
        $(".sticky-wrapper").css("height", +$("#sticktop").innerHeight() + "px");
    });

    $("body").on("click",".dl-menu > li > a",function(e){
        var $this = $(this),
            p = $this.parent();
        if(p.children("ul").length){
            e.preventDefault();
            p.children("ul").addClass("expand");
            $this.parents(".dl-menu").addClass("backed");
        }else{
            $(".dl-menu").removeClass("xvMenuShow");
            $(".dl-menu > li").removeClass("active");
            $this.parent().addClass("active");
        }
    });
    
    $("body").on("click",".dl-menu > li > ul > li > a",function(e){
        if(!$(this).hasClass("backLvl")){
            $(".dl-menu").removeClass("backed");
            $(".dl-menu").removeClass("xvMenuShow");
        }
        
    });
    
    $("body").on("click",".menuTrigger",function(e){
        e.preventDefault();
        $(".dl-menu").toggleClass("xvMenuShow");
    });
    
    $("body").on("click",".backLvl",function(e){
        var $this = $(this);
        e.preventDefault();
        $this.parents(".dl-submenu").removeClass("expand");
        $this.parents(".dl-menu").removeClass("backed");
    });
    
    $(".dl-submenu").each(function(){
        var $this = $(this);
        $this.prepend('<li class="gobackLvl"><a class="backLvl" href="#"><i class="fa fa-long-arrow-left"></i>Go Back</li>');
    });

    $('.fb-share').click(function(e) {
        e.preventDefault();
        window.open($(this).attr('href'), 'fbShareWindow', 'height=450, width=550, top=' + ($(window).height() / 2 - 275) + ', left=' + ($(window).width() / 2 - 225) + ', toolbar=0, location=0, menubar=0, directories=0, scrollbars=0');
        return false;
    });

});

