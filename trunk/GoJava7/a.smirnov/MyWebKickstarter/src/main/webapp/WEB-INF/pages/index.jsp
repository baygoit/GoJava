<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
	<jsp:param value="Main page" name="title" />
</jsp:include>

    <div class="container">
        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                    <div id="carousel-example-generic" class="carousel slide">
                        
                        <!-- Indicators -->
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="img-responsive img-full" src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=0B2I6VTKFP4LhRGNwSVBJM2FMbXc" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=0B2I6VTKFP4Lhd1U4MWFHTEt1R2M" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="https://drive.google.com/uc?export=download&confirm=no_antivirus&id=0B2I6VTKFP4LhRkhUWE9Hb1ZHblU" alt="">
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>
                    
                    <!-- Show random quote -->
                    <h1 class="brand-before">
                        <small>Quote of the day</small>
                    </h1>
                    <h3 class="brand-name">${quote.text}</h3>
                    <hr class="tagline-divider">
                    <h2>
                        <small>(c)
                            <strong>${quote.author}</strong>
                        </small>
                    </h2>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; My Kickstarter Website 2016</p>
                </div>
            </div>
        </div>
    </footer>
   
    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
		
<jsp:include page="footer.jsp" />