<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<c:import url="../includes/inicioHTML.jsp">
    <c:param name="elTitulo" value="Catálogo de ingredientes" />
</c:import>

<c:import url="../includes/navbar.jsp" />


<section class="container">
    <div class="row pt-3">
        <h1>Catálogo de ingredientes</h1>
        <p class="lead mb-0">Nuestro sitio cuenta con recetas utilizando estos ingredientes</p>
    </div>
    <hr/>
    <c:choose>
        <c:when test = "${listaDeIngredientes != null && !listaDeIngredientes.isEmpty()}">
            <div class="row g-4 mb-3 row-cols-1 row-cols-sm-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5" data-masonry='{"percentPosition": true }' >
                <c:import url="cardIngrediente.jsp" />
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

<!--<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>-->
<script src="assets/js/masonry.pkgd.min.js"></script>
<script src="assets/js/text-color-according-BG.js"></script>
<script>
    [...document.getElementsByClassName("card")].forEach(card => {
        const nuevoColor = textColorAccordingBG(card.style.backgroundColor.match(/\d+/g));
        card.children[1].children[0].children[0].style.color = nuevoColor;
        //card.children[1].children[1].style.color = nuevoColor;
    });
</script>

<c:import url="../includes/footer.jsp"/>
<c:import url="../includes/finHTML.jsp"/>