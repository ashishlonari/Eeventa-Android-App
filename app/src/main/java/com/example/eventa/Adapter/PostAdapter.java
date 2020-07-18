package com.example.eventa.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import com.example.eventa.Model.Post;
import com.example.eventa.PostDetailFragment;
import com.example.eventa.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {


    private Context mContext;
    private List<Post> mPosts;
    private FirebaseUser firebaseUser; //Object of Firebase is created

    public PostAdapter(Context mContext, List<Post> mPosts) {
        this.mContext = mContext;
        this.mPosts = mPosts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.post_item, parent, false);
        return new PostAdapter.ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        //To get instance of firebase Authentication

        final Post post = mPosts.get(position);

        Glide.with(mContext).load(post.getPostimage())
                .into(holder.post_image);


        if (post.getDescription().equals("")){
            holder.description.setVisibility(View.GONE);
        } else {
            holder.description.setVisibility(View.VISIBLE);
            holder.description.setText(post.getDescription());
        }


        if (post.getDescription().equals("")){
            holder.title.setVisibility(View.GONE);
        } else {
            holder.title.setVisibility(View.VISIBLE);//To set the description of Visibility
            holder.title.setText(post.getTitle());//To set text of title in Firebase
        }



        holder.post_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", MODE_PRIVATE).edit();
                editor.putString("postid", post.getPostid());
                editor.apply();

                //To get the id of post from the realtie database to view the post
                ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PostDetailFragment()).commit();

                //Get details from fragment container in xml file and begin transaction after linking
            }
        });

        holder.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String url="https://docs.google.com/forms/d/1rPrtSGsMmJXkzF21egQTG_bR7CHiwLtGyUHSBmNYbyY/edit";
             Intent i=new Intent(Intent.ACTION_VIEW);
             i.setData(Uri.parse(url));
             mContext.startActivity(i);

             //For the register through google forms and after onclick we get the registeration of google forms

            }
        });



    }

    //Getter for getItem count after pressing Generate
    @Override
    public int getItemCount() {
        return mPosts.size();

    }


    //A new class ViewHolder extending Recycler View
    //Get image id located in  xml files
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView post_image, like, comment, save, more;
        public TextView likes, publisher, description, comments,title;
        public Button register;

        public ViewHolder(View itemView) {
            super(itemView);

            post_image = itemView.findViewById(R.id.post_image);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            save = itemView.findViewById(R.id.save);
            description = itemView.findViewById(R.id.description);
            comments = itemView.findViewById(R.id.comments);
            register =itemView.findViewById(R.id.reg_but);
            title =itemView.findViewById(R.id.title);

        }

        }
    }


