## MICROSERVICE E-BANKING

<b>Création du projet</b> <br/>
<img src="images/1.png" alt="creation du projet"/> <br/>
# 1- Création du microservice beneficiaire-service
    ## 1.a- Création d'un module
<img src="images/2.png" alt="module beneficiaire service"/> <br/>
<img src="images/3.png" alt="module beneficiaire service"/> <br/>
    <b>Ajout des modules</b> <br/>
<img src="images/4.png" alt="module beneficiaire service"/> <br/>
    <b>1.b- Création de l'entité</b> <br/>
<img src="images/5.png" alt="entite beneficiaire"/> <br/>
    <b>1.c- Création du repository</b> <br/>
<img src="images/7.png" alt="repository beneficiaire"/> 
<p>Ici nous avons utilisé l'anotation @RepositoryRestResource afin de permettre de créer automatiquement une API Restfull.</p>
    <b>1.d- Création d'un enum</b> <br/>
<img src="images/6.png" alt="Enumérateur"/> <br/>
    <b>1.e- Configuration dans le fichier application.properties</b> <br/>
<img src="images/9.png" alt=""/> <br/>
    <b>1.f- Test du microservice</b> <br/>
<img src="images/8.png" alt="test de la partie back"/> <br/>
<img src="images/10.png" alt="test de la partie back"/> <br/>
<img src="images/11.png" alt="test de la partie back"/> <br/>

# 2- Création du module virement-service
<p>Il faut suivre les étapes précédentes. Cepedant, comme les deux micro-services doivent communiquer entre eux, il faut utiliser
feign.</p>
<b>2.a- Création de l'entité Virement</b> <br/>
<p>Ici nous avons utilisé l'annotation @transient qui permet à ce que l'attribut ne soit pas enregistré en base de données.
Cela est fait également pour effectuer le lien entre les deux class. Pour cela la class Beneficiaire a été duppliqué dans un paquage
appelé model.</p>
<img src="images/12.png" alt="Entité virement"/> <br/>
<p>Relation entre la clss Virement et la class Beneficiaire.</p>
<img src="images/13.png" alt="Entité virement"/> <br/>

# 3- Mise en place de la GATEWAY
<p>Dans l'architecture micro-service le consommateur des micro-service ne communique pas directement avec les micro-services mais plutôt avec la gateway.</p>
<b>3.a- Dépendances</b> <br>
<img src="images/14.png" alt="les pluggins"/> <br/>
<p>Pour la gateway il faut utiliser la dépendance suivante</p>
<img src="images/15.png" alt="gateway"/> <br/>
<b>3.b- Configuration statique de la gateway</b> <br>
<p>Utiliser le fichier application.yml</p>
<img src="images/16.png" alt="gateway"/> <br/>

# 4- Mise en place de DISCOVERY 
<p>Permettre à chaque microservice de s'enregistrer afin que la gateway puisse se connecter au microservice via son nom</p>
<img src="images/17.png" alt="gateway"/> <br/>
<b>4.a- Activation de discovery service</b> <br>
<img src="images/18.png" alt="gateway"/> <br/>
<b>4.b- Configuration</b> <br>
<img src="images/19.png" alt="gateway"/> <br/>
<b>4.c- Affichage de l'interface de discovery server</b> <br>
<img src="images/20.png" alt="gateway"/> <br/>
<b>4.d- Configuration de la gateway et des microservices afin qu'il s'enregistre automatiquement</b> <br>
<p>Instruction à utiliser dans tous les fichiers application.properties</p>
<img src="images/21.png" alt="Config"/> <br/>
<b>4.e- Configuration de la gateway pour qu'il puisse reconnaitre les microservices avec uniquement leurs noms</b> <br>
<p>Il faut effectuer cette modification dans le fichier <em>application.yml</em></p>
<img src="images/22.png" alt="Config"/> <br/>

# 5- Configuration dynamique du routage

