<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<jsp:include page="../includes/inicioHTML.jsp">
    <jsp:param name="elTitulo" value="Catálogo de ingredientes" />
</jsp:include>

<jsp:include page="../includes/navbar.jsp" />


<section class="container">
    <div class="row pt-3">
        <h1>Catálogo de ingredientes</h1>
        <p class="lead mb-0">Nuestro sitio cuenta con recetas utilizando estos ingredientes</p>
    </div>
    <hr/>
    <c:choose>
        <c:when test = "${listaDeIngredientes != null && !listaDeIngredientes.isEmpty()}">
            <div class="row g-4 mb-3 row-cols-1 row-cols-sm-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5" data-masonry='{"percentPosition": true }' >
                <jsp:include page="cardIngrediente.jsp" />
            </div>
        </c:when>
        <c:otherwise>
            <div class="row my-4">
                <div class="col-12">
                    <p class="display-5 text-danger">Ooops! Parece que no hay ingredientes...</p>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</section>
  

<script src="assets/js/text-color-according-BG.js"></script>
<script>
    [...document.getElementsByClassName("card")].forEach(card => {
        const nuevoColor = textColorAccordingBG(card.style.backgroundColor.match(/\d+/g));
        card.children[1].children[0].children[0].style.color = nuevoColor
        //card.children[1].children[1].style.color = nuevoColor;
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/finHTML.jsp"/>