package com.example.eventa.Model;


    public class Post {
        private String postid;
        private String postimage;
        private String description;
        private String publisher;
        private String title;

        public Post(String postid,String title, String postimage, String description, String publisher) {
            this.postid = postid;
            this.postimage = postimage;
            this.description = description;
            this.publisher = publisher;
            this.title=title;
        }

        public Post() {
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getPostimage() {
            return postimage;
        }

        public void setPostimage(String postimage) {
            this.postimage = postimage;
        }

        public String getDescription() {
            return description;
        }

        public String getTitle() {
            return title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }
    }

