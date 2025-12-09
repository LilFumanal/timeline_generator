Cette application est créée dans le cadre de ma montée en compétence Java21, pour le passage de ma certification ENI: Programmer en Java.

# Objectif
Créer une application Java + JavaFX permettant de construire, visualiser et exporter des frises chronologiques personnalisées (événements, périodes, catégories), de manière simple et ergonomique.

## Technologies & Architecture
Java 21 (LTS)  
JavaFX pour l’UI et le rendu graphique  
SQLite comme format de sauvegarde interne (.timeline ou .db)  
JDBC pour l’accès aux données  
Maven  

L’application se compose de :
- Éditeur (formulaires pour événements, périodes, catégories)
- Zone d’aperçu de la frise (rendu temps réel)
- Moteur de rendu JavaFX
- Système de persistance (SQLite)

## Données gérées
Événements : titre, description, date (LocalDate), couleur, catégorie  
Périodes : début + fin (LocalDate)  
Catégories : nom, couleur, visibilité  

## Fonctionnalités principales
Ajouter / modifier / supprimer événements, périodes, catégories  
Rendu graphique dynamique  
Zoom & déplacement  
Sauvegarde/chargement via SQLite  
Export PNG et PDF