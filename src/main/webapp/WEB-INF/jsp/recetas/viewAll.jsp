<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<jsp:include page="../includes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="Catálogo de recetas" />
</jsp:include>

<jsp:include page="../includes/navbar.jsp" />


<section class="container">
    <div class="row pt-3">
        <h1>Catálogo de recetas</h1>
        <p class="lead mb-0">Agradecemos a los usuarios por su colaboración</p>
    </div>
    <hr/>
    <c:choose>
        <c:when test = "${listaDeRecetas != null && !listaDeRecetas.isEmpty()}">
            <div class="row g-4 mb-3 row-cols-1 row-cols-sm-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5" data-masonry='{"percentPosition": true }' >
                <jsp:include page="cardReceta.jsp" />
            </div>
        </c:when>
        <c:otherwise>
            <div class="row my-4">
                <div class="col-12">
                    <p class="display-5 text-danger">Ooops! Parece que no hay recetas...</p>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</section>
  
<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/finHTML.jsp"/>