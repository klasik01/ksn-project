import ejb.ArticleManager;
import ejb.CommentManager;
import ejb.UserManager;
import entity.ArticleEntity;
import entity.CommentEntity;
import entity.UserEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class main {
    public static void main(String[] args) {

        UserManager userManager = new UserManager();
        ArticleManager articleManager = new ArticleManager();
        CommentManager commentManager = new CommentManager();

        //List<UserEntity> users = userManager.getUsers();
        //users.forEach(user -> System.out.println(user.toString()));

        // userManager.deleteUser(users.get(0));

        UserEntity newUser = new UserEntity();
        newUser.setId(UUID.randomUUID().toString());
        newUser.setName("Henrik");
        newUser.setSurname("Larson2");
        newUser.setEmail("skkaslkika@seznam.com");
        newUser.setPassword("Heslo5");
        newUser.setActive(false);
        userManager.saveUser(newUser);
//
        ArticleEntity newArticle = new ArticleEntity();
        newArticle.setId(UUID.randomUUID().toString());
        newArticle.setAuthor(newUser);
        newArticle.setCategory("SPORT");
        newArticle.setContent("Super nářez");
        newArticle.setName("PLzen vyhrala");
        newArticle.setDate(new Date());
//
        articleManager.saveArticle(newArticle);
        System.out.println("Create article");
//
        CommentEntity newComment = new CommentEntity();
        newComment.setId(UUID.randomUUID().toString());
        newComment.setArticle(newArticle);
        newComment.setAuthor(newUser);
        newComment.setContent("Neumíš to");
        newComment.setDate(new Date());

        commentManager.saveComment(newComment);

        CommentEntity newComment2 = new CommentEntity();
        newComment2.setId(UUID.randomUUID().toString());
        newComment2.setArticle(newArticle);
        newComment2.setAuthor(newUser);
        newComment2.setContent("Ty taky ne");
        newComment2.setDate(new Date());

        commentManager.saveComment(newComment2);

        List<CommentEntity> comments = commentManager.getComments();
        comments.forEach(commentEntity -> System.out.println(commentEntity.getContent()));


    }
}
