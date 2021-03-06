package com.blog.ljw.firstbolg.service;

import com.blog.ljw.firstbolg.persistence.ArticleMapper;
import com.blog.ljw.firstbolg.pojo.Article;
import com.blog.ljw.firstbolg.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getAll(){
        return articleMapper.getAll();
    }

    public int getCategoryCount(String category){
        return articleMapper.getCategoryCount(category);
    }

    public Article getArticlById(String articleId){
        return articleMapper.getArticlById(articleId);
    }

    public int insertArticle(Article article){
        return articleMapper.insertArticle(article)>0 ? article.getId() : 0;
    }

    public  List<Article> selectLatestArticles(int offset,int limit){
        return articleMapper.selectLatestArticles(offset,limit);
    }

    public int getArticleCount(){
        return articleMapper.getArticleCount();
    }

    public Category getCategory(){
        String []categoryName = {"JAVA","Web","Linux","Network","Database","Algorithm","Other"};
        Category category = new Category();
        for(String name:categoryName){
            category.set(name,articleMapper.getCategoryCount(name));
        }
        return  category;
    }
}
