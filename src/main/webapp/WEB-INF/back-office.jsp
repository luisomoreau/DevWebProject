<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<section>
    <div class="row">
        <div class="shell6">
            <h4 class="center">Ajouter un produit</h4>
            <form action="mailto:louis.moreau@hei.fr" >
                <div class="shell4">
                    <label>Nom :* </label>
                </div>
                <div class="shell8">
                    <input type="text" placeholder="Nom" required="true">
                </div>
                <div class="shell4">
                    <label>Catégorie :* </label>
                </div>
                <div class="shell8">
                    <select required="true">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>
                </div>
                <div class="shell4">
                    <label>Image : </label>
                </div>
                <div class="shell8">
                    <fieldset>
                        <input type="file" name="picture" id="picture" />
                    </fieldset>
                </div>
                <div class="shell4">
                    <label>Description :* </label>
                </div>
                <div class="shell8">
                    <textarea placeholder="Description du produit"></textarea>
                </div>
                <div class="shell4">
                    <button class="button-blue" value="Valider">Envoyer</button>
                </div>
            </form>
        </div>

        <div class="shell4">
            <h4 class="center">Ajouter une catégorie</h4>
            <form action="mailto:louis.moreau@hei.fr" >
                <div class="shell4">
                    <label>Catégorie :* </label>
                </div>
                <div class="shell4">
                    <input type="text" placeholder="Nom" required="true">
                </div>
                <div class="shell4">
                    <button class="button-blue" value="Valider">Créer</button>
                </div>
            </form>
        </div>
    </div>
</section>

<c:import url="footer.jsp"></c:import>