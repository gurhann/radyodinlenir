jQuery(function($) {
    "use strict";

   
    /*====================
    Main
    =====================*/
    function contactemaps(selector_map, address, type, zoom_lvl, map_theme) {
        var map = new google.maps.Map(document.getElementById(selector_map), {
            mapTypeId: google.maps.MapTypeId.type,
            scrollwheel: false,
            draggable: false,
            zoom: zoom_lvl,
            styles: map_theme,
        });
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({
                'address': address
            },
            function(results, status) {
                if (status === google.maps.GeocoderStatus.OK) {
                    new google.maps.Marker({
                        position: results[0].geometry.location,
                        map: map,
                        /* icon: map_pin*/
                    });
                    map.setCenter(results[0].geometry.location);
                }
            });
    }

    function suonoApp() {

        /*custome Placeholder*/
        $('.field-wrap input,.field-wrap textarea').each(function(index, element) {
            if ($(this).val() !== "") {
                $('label[for=' + $(this).attr("id") + ']').hide();
            }
        });

        $('.field-wrap input,.field-wrap textarea').focus(function() {
            $('label[for=' + $(this).attr("id") + ']').hide();
        });
        $('.field-wrap input,.field-wrap textarea').blur(function() {
            if ($(this).val() === "") {
                $('label[for=' + $(this).attr("id") + ']').show();
            }
        });
    
     
        /*======================================
        custome selectbox
        =======================================*/
        $('.custome-select select').on('change', function() {
            var p = $(this).parent(".custome-select");
            p.find('span').html($(this).find('option:selected').text());
        });

   

 
        

        /*=======================================
        packery
        =======================================*/
        if ($('.xvPackeryItems').length) {
            var packery = $('.xvPackeryItems');
            packery.packery({
                itemSelector: '.xvPackeryItem',
                gutter: 0
            });
        }
        
    
   

    } /*suonoApp*/
    suonoApp();

    /*======================================
    Menu
    ======================================*/
    
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




