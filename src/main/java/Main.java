/*
 * Copyright 2022 StreamSets Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Main {

  public static final String JDBC_CONNECTION_STRING = "jdbc:postgresql://10.0.0" +
      ".27:5432/example?user=postgres&password=postgres&stringtype=unspecified";

  public static final String INSERT_STMT = "INSERT INTO event2 (id, ts, details) VALUES (?, ?, ?)";

  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Class.forName("org.postgresql.Driver");
    Connection conn = DriverManager.getConnection(JDBC_CONNECTION_STRING);
    int randomInt = new Random().nextInt();
    String timestampz = "2022-06-07T14:48:23.401+0000";
    String details = "askjdfhgskjgsd";

    PreparedStatement preparedStatement = conn.prepareStatement(INSERT_STMT);
    preparedStatement.setInt(1, randomInt);
    preparedStatement.setString(2, timestampz);
    preparedStatement.setString(3, details);

    preparedStatement.execute();

  }

}
