export class Restaurant {
    nom?: string;
    image?: string;
    prix?: number;

    constructor (nom, image, prix?){
        this.nom = nom;
        this.image = image;
        this.prix = prix;
    }
}
