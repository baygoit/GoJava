<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="alert alert-danger" role="alert"> Redirecting to project page in <span class="label label-danger" id="countdown">5</span></div>
<script type="text/javascript">
(function () {
    var timeLeft = 5,
        interval;

    var timeDec = function (){
        timeLeft--;
        document.getElementById('countdown').innerHTML = timeLeft;
        if(timeLeft === 0){
            clearInterval(interval);
            window.location="<c:url value="/project/${dto.projectId}" />";
        }
    };
    interval = setInterval(timeDec, 1000);
})();
</script>