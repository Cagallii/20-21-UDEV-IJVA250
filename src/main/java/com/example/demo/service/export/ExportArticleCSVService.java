package com.example.demo.service.export;

import com.example.demo.dto.ArticleDto;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
public class ExportArticleCSVService {

    @Autowired
    private ArticleService articleService;

    public void exportAll(PrintWriter writer) {


        //génération d'un fichier CSV exemples avec 2 colonnes et 4 lignes
        writer.println("Libelle;Prix");

        List<ArticleDto> listes = articleService.findAll();

        articleService.findAll().stream().forEach(article -> writer.println(article.libelle + ";" + article.prix));

       /* Deuxième possibilité
       for (ArticleDto article: listes) {
            writer.println(article.libelle + ";" + article.prix);
        }
        //Troisième possibilité
       for(int i =0; i<listes.size(); i++){
           writer.println(listes.get(i).libelle + ";" + listes.get(i).prix);
       }*/

        // TODO remplacer par les vrais articles de la base de données, tips : rechercher tous les articles : articleService.findAll();
    }

}
