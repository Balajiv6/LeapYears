$('#calculateLeapYear').click(function(e) {
   e.preventDefault(); // prevent form from reloading page
   $('#statusInformation').hide();
   year_entered = $('#year')[0].value;

   if(year_entered == "" || year_entered == null){
        $('#statusInformation').show();
        $('p').text("");
        $('p').append('<span style="color:red;">Please Enter the Value</span>');
   }else{
       var url = "http://localhost:9080/bnppfortis/channels/validate/leap-year/"+year_entered;
       $.ajax({
          'url' : url,
          'type' : 'GET',
          success: function(data) {
               $('#statusInformation').show();
               $('p').text("");
               $('p').append('<span>'+data+'</span>');
          }
       });
   }

});