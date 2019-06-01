document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.sidenav');
    M.Sidenav.init(elems);
  });

$(document).ready(function(){
    $('.modal').modal({
        dismissible: false,
        startingTop: '0%'
    });
  });