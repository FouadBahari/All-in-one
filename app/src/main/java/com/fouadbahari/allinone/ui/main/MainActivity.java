package com.fouadbahari.allinone.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fouadbahari.allinone.R;
import com.fouadbahari.allinone.adapter.PostsAdapter;
import com.fouadbahari.allinone.model.PostModel;

import java.util.List;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel= ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPosts();
         RecyclerView recyclerView=findViewById(R.id.recycler_id);
        final PostsAdapter postsAdapter=new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postsAdapter);

        postViewModel.mutableLiveDataPostModel.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postsAdapter.setList(postModels);

            }
        });
    }
}