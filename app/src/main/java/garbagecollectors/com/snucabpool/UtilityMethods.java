package garbagecollectors.com.snucabpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import garbagecollectors.com.snucabpool.activities.BaseActivity;

public class UtilityMethods
{
    public static User getUserFromDatabase(String uid)
    {
        User userToBeFound = null;
        ArrayList<User> userList = BaseActivity.getUserList();

        for(User user: userList)
        {
            if(user.getUserId().equals(uid))
            {
                userToBeFound = user;
                break;
            }
        }

        return userToBeFound;
    }

    static boolean addRequestInList(ArrayList<TripEntry> requestSent, TripEntry tripEntry)
    {
        boolean flag = false;

        if(requestSent == null)
            requestSent = new ArrayList<>();

        for(TripEntry e: requestSent)
        {
            if(e.getEntry_id().equals(tripEntry.getEntry_id()))
            {
                flag = true;
                break;
            }
        }

        if(!flag)
            requestSent.add(tripEntry);

        return flag;
    }

    static boolean addRequestInMap(HashMap<String, ArrayList<User>> requestsRecieved, String key, User entryUser)
    {
        boolean flag = false;

        if(requestsRecieved == null)
            requestsRecieved = new HashMap<>();

        for (Map.Entry<String, ArrayList<User>> entry : requestsRecieved.entrySet())
        {
            if (entry.getKey().equals(key))
            {
                for (User user : entry.getValue())
                {
                    if (user.getUserId().equals(entryUser.getUserId()))
                    {
                        flag = true;
                        break;
                    }
                }

                if (!flag)
                {
                    entry.getValue().add(entryUser);
                    break;
                }
            }
        }

        return flag;
    }

    public static void updateTripList(ArrayList<TripEntry> tripEntryList, TripEntry tripEntry)
    {
        Iterator<TripEntry> iterator = tripEntryList.iterator();

        while (iterator.hasNext())
        {
            TripEntry tripEntryFromList = iterator.next();

            if(tripEntryFromList.getEntry_id().equals(tripEntry.getEntry_id()))
            {
                iterator.remove();
                break;
            }
        }

        tripEntryList.add(tripEntry);
    }

    public static void updateUserList(ArrayList<User> userList, User user)
    {
        Iterator<User> iterator = userList.iterator();

        while (iterator.hasNext())
        {
            User userFromList = iterator.next();

            if(userFromList.getUserId().equals(user.getUserId()))
            {
                iterator.remove();
                break;
            }
        }

        userList.add(user);
    }
}
