import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Instagram {
    
    
   
    Map<Integer,ArrayList<Integer>> posts=new HashMap<>();
   
    Map<Integer,Integer> stories=new HashMap<>();
    Map<Integer,ArrayList<Integer>> followingList=new HashMap<>();

    void post(int userId,int postId){

        if(posts.get(userId)==null){
          ArrayList<Integer> postList=new ArrayList<>();
          postList.add(postId);
          posts.put(userId, postList);
          return;
        }

        
       
        //for unique id of post
 
    for(Map.Entry<Integer,ArrayList<Integer>> entry: posts.entrySet()){
        ArrayList<Integer> postlist=entry.getValue();
             for(int i=0;i<postlist.size();i++){
         if(postId==postlist.get(i)){
            System.out.println("post id should be unique");
            return;

         }
       }
    }
    ArrayList<Integer> postlist=posts.get(userId);
        postlist.add(postId);
        posts.put(userId, postlist);
        
        
    }

    ArrayList<Integer> feed(int userId){
       ArrayList<Integer> postList=posts.get(userId);
       //for latest posts
       ArrayList<Integer> postListWRTDate=new ArrayList<>();
       for(int i=0;i<postList.size();i++){
        postListWRTDate.add(postList.get(postList.size()-i-1));
       }
       return postListWRTDate;
    }
   void follow(int userId1,int userId2){
    if(followingList.get(userId1)==null){
        ArrayList<Integer> followingL=new ArrayList<>();
        followingL.add(userId2);
        followingList.put(userId1, followingL);
        return;
      }
      ArrayList<Integer> followingL=followingList.get(userId1);
      followingL.add(userId2);
      followingList.put(userId1, followingL);
   }
   void unfollow(int userId1,int userId2){
     ArrayList<Integer> followingL=followingList.get(userId1);
     for(int i=0;i<followingL.size();i++){
        if(followingL.get(i)==userId2){
            followingL.remove(i);
            return;
        }
     }
   }

   //upload story
   void upload_story(int userId,int storyId){
    if(stories.get(userId)!=null){
        System.out.println("you can upload only one story at a time");
        return;
    }
      stories.put(userId, storyId);
      
   }
  ArrayList<Integer> getStories(int userId){
    ArrayList<Integer> storyList=new ArrayList<>();
    //if user uploaded his/her story
    if(stories.get(userId)!=null){
        storyList.add(stories.get(userId));
    }
    ArrayList<Integer> followingL=followingList.get(userId);
    for(int i=0;i<followingL.size();i++){
        if(stories.get(followingL.get(followingL.size()-i-1))!=null){
            storyList.add(stories.get(followingL.get(followingL.size()-i-1)));
        }
    }



    return storyList;
  }

    public static void main(String[] args) {
        Instagram instagram=new Instagram();
        instagram.post(1, 319);
        instagram.post(1, 320);
        instagram.post(1, 321);
        instagram.post(1, 322);
        instagram.post(1, 323);
        instagram.post(2, 324);
        instagram.post(2, 325);
        instagram.post(2, 326);
        instagram.post(2, 327);
        instagram.post(2, 328);
        instagram.post(2, 329);
        
        
        //for user1
       System.out.println(instagram.feed(1));
       //for user2
       System.out.println(instagram.feed(2));

       instagram.follow(1, 2);
       instagram.follow(1, 3);
       instagram.follow(1, 4);
       instagram.follow(1, 5);
       instagram.follow(1, 6);
       instagram.follow(1, 7);


       instagram.upload_story(2, 1);
       instagram.upload_story(3, 3);
       instagram.upload_story(4, 4);
       instagram.upload_story(5, 5);
       instagram.upload_story(6, 7);
       instagram.upload_story(7, 9);
       instagram.upload_story(1, 11);



      System.out.println("stories ->");
      System.out.println(instagram.getStories(1));
    }
}
