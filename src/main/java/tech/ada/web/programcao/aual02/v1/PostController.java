package tech.ada.web.programcao.aual02.v1;

import java.util.Scanner;

public class PostController {

    private final PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    public static void main(String[] args) {
        var postController = new PostController();

        //API POST Resource
        var post = postController.getPost();
        //var post = postController.createPost();

        //API RESPONSE
        System.out.println(post);
    }

    public String createPost() {
        System.out.println("Digite o título do post: ");
        String title = new Scanner(System.in).nextLine();

        System.out.println("Digite o corpo do post: ");
        String body = new Scanner(System.in).nextLine();

        Post post = new Post( title, body);

        return postService.createPost(post);
    }

    public String getPost() {
        System.out.println("Digite o ID do post(ex.:1): ");
        String id = new Scanner(System.in).nextLine();

        return postService.getPost(id);
    }
}
