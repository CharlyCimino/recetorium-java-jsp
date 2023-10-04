<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:forEach items="${listaDeRecetas}" var="receta">  
    <div class="col">        
        <div class="card shadow">
            <img src="assets/img/recetas/${receta.foto}" class="card-img" alt="Foto de ${receta.nombre}">
            <div class="card-body">
              <h5 class="card-title">${receta.nombre}</h5>
              <p class="card-text">                  
                <c:forEach items="${receta.items}" var="item">
                    <span class="badge my-badge" style="background-color: ${item.ingrediente.color};">${item.ingrediente.nombre}</span> 
                </c:forEach>
              </p>              
              <p class="card-text"><small>Creada por *AUTOR*</small></p>
            </div>            
        </div>
    </div>
</c:forEach>






