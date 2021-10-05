package com.example.retrofitdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.retrofitdemo.apitestmodel.Comment;
import com.example.retrofitdemo.apitestmodel.JsonPlaceHolderApi;
import com.example.retrofitdemo.databinding.ActivityMainBinding;
import com.example.retrofitdemo.model.Addresss;
import com.example.retrofitdemo.model.Employee;
import com.example.retrofitdemo.model.FamilyMember;
import com.example.retrofitdemo.apitestmodel.Post;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

//        getPosts();
//        getComments();
//        createPost();
//        updatePost();
          deletePost();

    }

    private void deletePost() {
        Call<Void> call = jsonPlaceHolderApi.deletePost(3);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                mainBinding.textView.setText("Code: " + response.code());
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                mainBinding.textView.setText(t.getMessage());
            }
        });
    }

    private void updatePost() {
        Post post = new Post(26, null, "body");
        Call<Post> call = jsonPlaceHolderApi.putPost(5,post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                if (!response.isSuccessful()){
                    mainBinding.textView.setText("Code: " + response.code());
                    return;
                }

                Post postResponse = response.body();
                String content = "";
                assert postResponse != null;
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Body: " + postResponse.getText() + "\n\n";

                mainBinding.textView.append(content);

            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                mainBinding.textView.setText(t.getMessage());
            }
        });
    }

    private void createPost() {
//        Post post = new Post(23, "Tittle", "body");

        Map<String, String> params = new HashMap<>();
        params.put("userId", "23");
        params.put("Title", "Hello world");
        Call<Post> call = jsonPlaceHolderApi.createPost(params);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                if (!response.isSuccessful()){
                    mainBinding.textView.setText("Code: " + response.code());
                    return;
                }

                Post postResponse = response.body();
                String content = "";
                assert postResponse != null;
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Body: " + postResponse.getText() + "\n\n";

                mainBinding.textView.append(content);

            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                mainBinding.textView.setText(t.getMessage());

            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call = jsonPlaceHolderApi.getComments("posts/3/comments");
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
                if (!response.isSuccessful()){
                    mainBinding.textView.setText("Code: " + response.code());
                    return;
                }
                List<Comment> comments = response.body();

                assert comments != null;
                for (Comment comment:comments){
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "ID: " + comment.getPostId() + "\n";
                    content += "User ID: " + comment.getName() + "\n";
                    content += "Title: " + comment.getEmail() + "\n";
                    content += "Text: " + comment.getText() + "\n\n";
                    mainBinding.textView.append(content);

                }

            }

            @Override
            public void onFailure(@NonNull Call<List<Comment>> call, @NonNull Throwable t) {
                mainBinding.textView.setText(t.getMessage());
            }
        });


    }

    private void jsonDemo(){

        Gson gson = new Gson();

        Addresss address = new Addresss("Bangladesh", "Dhaka");

        List<FamilyMember> memberList = new ArrayList<>();
        memberList.add(new FamilyMember( "Husband", 30));
        memberList.add(new FamilyMember( "Mother", 60));
        memberList.add(new FamilyMember( "Father", 70));

//        Employee employee = new Employee("Minhaj", 25, "minhaj@gmail.com", address, memberList);
//        String json = gson.toJson(employee);

        String json = "{\"firstName\":\"Minhaj\",\"address\":{\"City\":\"Dhaka\",\"Country\":\"Bangladesh\"},\"age\":25,\"family\":[{\"age\":30,\"role\":\"Husband\"},{\"age\":60,\"role\":\"Mother\"},{\"age\":70,\"role\":\"Father\"}],\"mail\":\"minhaj@gmail.com\"}";
        Employee employee = gson.fromJson(json, Employee.class);
        mainBinding.setDemo(employee);
    }

    private void getPosts(){
        Map<String, String> params = new HashMap<>();
        params.put("user_id", "1");
        params.put("_sort", "id");
        params.put("_order", "desc");

        Call <List<Post>> call = jsonPlaceHolderApi.getPosts(params);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    mainBinding.textView.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                assert posts != null;
                for (Post post:posts){
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";
                    mainBinding.textView.append(content);

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                mainBinding.textView.setText(t.getMessage());

            }
        });

    }

}