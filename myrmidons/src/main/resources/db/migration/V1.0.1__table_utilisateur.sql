CREATE TABLE IF NOT EXISTS Utilisateur (
    id SERIAL PRIMARY KEY, 
    email TEXT NOT NULL,
    mdp TEXT NOT NULL
);


CREATE TABLE IF NOT EXISTS Membres (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    adresse VARCHAR(200),
    date_naissance VARCHAR(50)
    );