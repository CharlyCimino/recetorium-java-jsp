<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<c:import url="../includes/inicioHTML.jsp">
    <c:param name="elTitulo" value="${receta.nombre}" />
</c:import>

<c:import url="../includes/navbar.jsp" />

<section class="container">
    <div class="row pt-3">
        <h1 class="text-center">Receta de ${receta.nombre}</h1>
        <div class="mx-auto col-12 col-md-6"><img src="assets/img/recetas/${receta.foto}" class="img-thumbnail rounded mx-auto d-block" alt="Foto de ${receta.nombre}"></div>        
        <h2>Ingredientes</h2>
        <ul>
            <c:forEach items="${receta.items}" var="item">                        
                <li>${item.cantidad} ${item.unidadMedida} de <a href="?accion=read&idIngrediente=${item.ingrediente.id}"><span class="badge my-badge" style="background-color: ${item.ingrediente.color};">${item.ingrediente.nombre}</span></a></li>
            </c:forEach>
        </ul>

        <h2>Instrucciones</h2>
        <p>${receta.instrucciones}</p>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
<script src="assets/js/text-color-according-BG.js"></script>
<script>
    [...document.getElementsByClassName("my-badge")].forEach(badge => {
        badge.style.color = textColorAccordingBG(badge.style.backgroundColor.match(/\d+/g));
    });
</script>

<c:import url="../includes/footer.jsp"/>
<c:import url="../includes/finHTML.jsp"/>