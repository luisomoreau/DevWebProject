<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:import url="header.jsp"></c:import>
<c:import url="menu.jsp"></c:import>

<div class="row">
    <div class="shell12 banner-mat-incendie">
        <div class="shell4">
            <img src="../img/FireExtinguisherTruck.jpg" width="100%">
        </div>
        <div class="shell8">
            <h2 class="center">Matériel incendie</h2>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent pellentesque ultricies fermentum. In hac habitasse platea dictumst. Donec accumsan magna leo, a facilisis lectus iaculis a. Fusce mattis libero ac enim efficitur efficitur. Vivamus et lorem condimentum, consequat felis ut, volutpat justo. Aliquam sed mollis magna. Mauris tristique eros nec purus cursus convallis. Sed fermentum erat sed arcu tincidunt viverra in a erat. Sed risus dui, gravida mollis risus sed, aliquet blandit dolor.
            </p>
            <p>
                Integer elementum, odio at auctor maximus, orci orci consectetur dui, et vestibulum diam magna ac massa. Suspendisse justo risus, malesuada id turpis rutrum, blandit dignissim magna. Curabitur pretium, felis eget ornare aliquet, lacus dui elementum est, eu lobortis ante magna vitae sapien. Integer vel venenatis eros. Maecenas eget turpis tincidunt, feugiat ante a, tincidunt nibh. Nulla congue rhoncus mauris, vel mattis urna venenatis vel. Sed ullamcorper pellentesque orci, dignissim vulputate ante condimentum ut.
            </p>
        </div>
    </div>
</div>
<div class="row">
    <div class="shell12">
        <div class="shell2 cart">
            <div class="shell2">
                <i class="fa fa-2x fa-align-center fa-shopping-cart"></i>
            </div>
            <div class="shell10">
                <h2 class="center">Devis</h2>
            </div>
            <div class="shell12">
                <p>Récapitulatif de devis (0) :</p>
                <a href="mes-devis" class="button-blue center">Valider</a>
            </div>
        </div>
        <div class="shell8">
            <div id="product" class="shell4 product">
                <h4>Lance à incendie</h4>
                <img src="../img/fr-default-home_default.jpg">
                <p>Catégories: Lance, CO2</p>
                <a class="button-blue" href="produit">Détails</a>
                <a href="#" class="button-blue">Demander un devis</a>
            </div>
            <div class="shell4 product">
                <h4>Extincteur CO2 2kg</h4>
                <img src="../img/fr-default-home_default.jpg">
                <p>Catégories: Extincteur, CO2</p>
                <a class="button-blue" href="produit.jsp">Détails</a>
                <a href="#" class="button-blue">Demander un devis</a>
            </div>
            <div class="shell4 product">
                <h4>Extincteur CO2 5kg</h4>
                <img src="../img/fr-default-home_default.jpg">
                <p>Catégories: Extincteur, CO2</p>
                <a class="button-blue" href="produit.jsp">Détails</a>
                <a href="#" class="button-blue">Demander un devis</a>
            </div>
            <div class="shell4 product">
                <h4>Tête alu</h4>
                <img src="../img/fr-default-home_default.jpg">
                <p>Catégorie: Pièces détachées, robineterie</p>
                <a class="button-blue" href="produit.jsp">Détails</a>
                <a href="#" class="button-blue">Demander un devis</a>
            </div>
            <div class="shell4 product">
                <h4>Lance à incendie</h4>
                <img src="../img/fr-default-home_default.jpg">
                <p>Catégorie: Extincteur</p>
                <a class="button-blue" href="produit.jsp">Détails</a>
                <a href="#" class="button-blue">Demander un devis</a>
            </div>
            <div class="shell4 product">
                <h4>Lance à incendie</h4>
                <img src="../img/fr-default-home_default.jpg">
                <p>Catégorie: Extincteur</p>
                <a class="button-blue" href="produit.jsp">Détails</a>
                <a href="#" class="button-blue">Demander un devis</a>
            </div>
        </div>

    </div>
</div>
<c:import url="footer.jsp"></c:import>