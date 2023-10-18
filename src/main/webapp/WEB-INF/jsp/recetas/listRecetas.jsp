<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<c:import url="../includes/inicioHTML.jsp">
    <c:param name="elTitulo" value="${customTitle}" />
</c:import>

<c:import url="../includes/navbar.jsp" />


<section class="container">
    <div class="row pt-3">
        <h1>${customTitle}</h1>
        <p class="lead mb-0">Agradecemos a los usuarios por su colaboración</p>
    </div>
    <hr/>
    <c:choose>
        <c:when test = "${listaDeRecetas != null && !listaDeRecetas.isEmpty()}">
            <div class="row g-4 mb-3 row-cols-1 row-cols-sm-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5" data-masonry='{"percentPosition": true }' >
                <c:import url="cardReceta.jsp" />
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
  

<script src="assets/js/masonry.pkgd.min.js"></script>
<script src="assets/js/text-color-according-BG.js"></script>
<script>
    [...document.getElementsByClassName("my-badge")].forEach(badge => {
        badge.style.color = textColorAccordingBG(badge.style.backgroundColor.match(/\d+/g));
    });
</script>

<c:import url="../includes/footer.jsp"/>
<c:import url="../includes/finHTML.jsp"/>