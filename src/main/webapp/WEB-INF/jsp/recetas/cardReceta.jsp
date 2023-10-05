<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:forEach items="${listaDeRecetas}" var="receta">  
    <div class="col">        
        <div class="card shadow">
            <a href="${pageContext.request.contextPath}/recetas?accion=read&id=${receta.id}"><img src="assets/img/recetas/${receta.foto}" class="card-img" alt="Foto de ${receta.nombre}"></a>
            <div class="card-body">
                <a href="${pageContext.request.contextPath}/recetas?accion=read&id=${receta.id}"><h5 class="card-title">${receta.nombre}</h5></a>
                <p class="card-text">   
                    <c:forEach items="${receta.items}" var="item">
                        <a href="?accion=read&idIngrediente=${item.ingrediente.id}"><span class="badge my-badge" style="background-color: ${item.ingrediente.color};">${item.ingrediente.nombre}</span></a>
                        </c:forEach>
                </p>              
                <p class="card-text"><small>Creada por *AUTOR*</small></p>
            </div>            
        </div>
    </div>
</c:forEach>





