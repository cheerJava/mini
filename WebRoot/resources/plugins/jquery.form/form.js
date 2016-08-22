(function($) {
    $.fn.loadData = function(options,enable) {
      var key,value,tagName,type,arr;
      for(x in options){
          key = x;
          value = options[x];
          $("[name='"+key+"'],[name='"+key+"[]']").each(function(){
              tagName = $(this)[0].tagName;
              type = $(this).attr('type');
              if(tagName=='INPUT'){
                  if(type=='radio'){
                      $(this).prop('checked',$(this).val()==value);
                  }else if(type=='checkbox'){
                      arr = value.split(',');
                      for(var i =0;i<arr.length;i++){
                          if($(this).val()==arr[i]){
                              $(this).attr('checked',true);
                              break;
                          }
                      }
                  }else if($(this).hasClass('datepicker')){
                      $(this).val( value);
                  }else{
                  	 $(this).val(value);
                  }
              }else if(tagName=='SELECT' || tagName=='TEXTAREA'){
                  $(this).val(value);
              }
              if(!enable){
               $(this).attr("disabled","disabled");
              }
          });
      }
    }
 
})(jQuery);