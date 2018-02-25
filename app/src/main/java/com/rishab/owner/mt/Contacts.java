package com.rishab.owner.mt;

/**
 * Created by OWNER on 19-02-2016.
 */
//it privid getter and setter methods
public class Contacts {
        private String name,review;

        public Contacts(String name,String review)
        {
            this.setName(name);
            this.setReview(review);
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

