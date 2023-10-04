<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:forEach items="${listaDeIngredientes}" var="ingrediente">  
    <div class="col">        
        <div class="card shadow" style="background-color: ${ingrediente.color}">
            <a href="/ingredientes/${ingrediente.id}"><img src="assets/img/ingredientes/${ingrediente.foto}" class="card-img" alt="Foto de ${receta.nombre}"></a>
            <div class="card-body">
                <h5 class="card-title"><a href="/ingredientes/${ingrediente.id}">${ingrediente.nombre}</a></h5>  
                <p class="card-text"><small>${2+2} recetas con este ingrediente</small></p>
            </div>            
        </div>
    </div>
</c:forEach>






