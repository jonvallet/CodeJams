package com.jonvallet.core;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jvalletw
 * Date: 5/12/13
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */
public interface Persistence {

    public Map<String, User> load();

    public void save(Map<String, User> users);

}
