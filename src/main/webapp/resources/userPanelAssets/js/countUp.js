function countUp(a,b,c,d,e){for(var f=0,g=["webkit","moz","ms"],h=0;h<g.length&&!window.requestAnimationFrame;++h)window.requestAnimationFrame=window[g[h]+"RequestAnimationFrame"],window.cancelAnimationFrame=window[g[h]+"CancelAnimationFrame"]||window[g[h]+"CancelRequestAnimationFrame"];window.requestAnimationFrame||(window.requestAnimationFrame=function(a,b){var c=(new Date).getTime(),d=Math.max(0,16-(c-f)),e=window.setTimeout(function(){a(c+d)},d);return f=c+d,e}),window.cancelAnimationFrame||(window.cancelAnimationFrame=function(a){clearTimeout(a)});var i=this;this.useEasing=!0,this.d="string"==typeof a?document.getElementById(a):a,i.startVal=Number(b),c=Number(c),this.countDown=b>c,d=Math.max(0,d||0),this.dec=Math.pow(10,d),this.duration=1e3*e||2e3,this.startTime=null,this.timestamp=null,this.remaining=null,this.frameVal=i.startVal,this.rAF=null,this.easeOutExpo=function(a,b,c,d){return c*(-Math.pow(2,-10*a/d)+1)*1024/1023+b},this.count=function(a){null===i.startTime&&(i.startTime=a),i.timestamp=a;var b=a-i.startTime;if(i.remaining=i.duration-b,i.useEasing)if(i.countDown){var e=i.easeOutExpo(b,0,i.startVal-c,i.duration);i.frameVal=i.startVal-e}else i.frameVal=i.easeOutExpo(b,i.startVal,c-i.startVal,i.duration);else if(i.countDown){var e=(i.startVal-c)*(b/i.duration);i.frameVal=i.startVal-e}else i.frameVal=i.startVal+(c-i.startVal)*(b/i.duration);i.frameVal=Math.round(i.frameVal*i.dec)/i.dec,i.countDown?i.frameVal=i.frameVal<c?c:i.frameVal:i.frameVal=i.frameVal>c?c:i.frameVal,i.d.innerHTML=i.addCommas(i.frameVal.toFixed(d)),b<i.duration?i.rAF=requestAnimationFrame(i.count):null!=i.callback&&i.callback()},this.start=function(a){return i.callback=a,isNaN(c)||isNaN(b)?(console.log("countUp error: startVal or endVal is not a number"),i.d.innerHTML="--"):i.rAF=requestAnimationFrame(i.count),!1},this.stop=function(){cancelAnimationFrame(i.rAF)},this.reset=function(){i.startTime=null,cancelAnimationFrame(i.rAF),i.d.innerHTML=i.addCommas(b.toFixed(d))},this.resume=function(){i.startTime=null,i.duration=i.remaining,i.startVal=i.frameVal,requestAnimationFrame(i.count)},this.addCommas=function(a){a+="";var b,c,d,e;for(b=a.split("."),c=b[0],d=b.length>1?"."+b[1]:"",e=/(\d+)(\d{3})/;e.test(c);)c=c.replace(e,"$1,$2");return c+d},i.d.innerHTML=i.addCommas(b.toFixed(d))}