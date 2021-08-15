package www.com.xworkz.dao;

import java.beans.Customizer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import www.com.xworkz.dto.WebSeriesDTO;
import www.com.xworkz.jdbcConstants.JDBCConstant;
import www.com.xworkz.webenum.Genertype;
import www.com.xworkz.webenum.StreamedInType;

public class WebSeriesDAOImpl implements WebSeriesDAO {
	List<WebSeriesDTO> collection = new ArrayList<WebSeriesDTO>();

	@Override
	public int save(WebSeriesDTO dto) {
		System.out.println("Saving dto in database");
		int aild = 0;
		Connection tempcon = null;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			tempcon = connection;
			connection.setAutoCommit(false);
			String query = "insert into webseries(name,noOfEpisodes,streamedIn,gener,yestAgeIndaNodbohudu) values (?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = stm.getGeneratedKeys();
			stm.setString(1, dto.getW_name());
			stm.setInt(2, dto.getW_noOfEpisodes());
			stm.setString(3, dto.getW_streamedIn().toString());
			stm.setString(4, dto.getW_gener().toString());
			stm.setInt(5, dto.getW_yestAgeIndaNodbohudu());
			if (resultSet.next()) {
				aild = resultSet.getInt(aild);

			}
			System.out.println(aild);
			dto.setW_id(aild);
			stm.execute();
			connection.commit();
			System.out.println(dto);
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				tempcon.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return aild;
	}

	@Override
	public void saveAll(Collection<WebSeriesDTO> collection) {

		System.out.println("Saving dto in database");
		Collection<WebSeriesDTO> col = new ArrayList<WebSeriesDTO>();

		Connection tempcon = null;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			tempcon = connection;
			connection.setAutoCommit(false);
			String query = "insert into webseries(name,noOfEpisodes,streamedIn,gener,yestAgeIndaNodbohudu) values (?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			collection.forEach(dto -> {
				int aild = 0;
				try {
					stm.setString(1, dto.getW_name());
					stm.setInt(2, dto.getW_noOfEpisodes());
					stm.setString(3, dto.getW_streamedIn().toString());
					stm.setString(4, dto.getW_gener().toString());
					stm.setInt(5, dto.getW_yestAgeIndaNodbohudu());
					stm.execute();
					ResultSet resultset = stm.getGeneratedKeys();
					if (resultset.next()) {
						aild = resultset.getInt(1);
					}
					dto.setW_id(aild);
					System.out.println(dto);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			connection.commit();
			col.addAll(collection);

		} catch (SQLException e) {

			e.printStackTrace();
			try {
				tempcon.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}

	@Override
	public Collection<WebSeriesDTO> findall() {

		System.out.println("Find all data's from table");
		Collection<WebSeriesDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "SELECT * FROM Webseries";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				createDTOFromResultSetValues(collection, resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	private void createDTOFromResultSetValues(Collection<WebSeriesDTO> collection, ResultSet resultSet)
			throws SQLException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		int w_noOfEpisodes = resultSet.getInt("noOfEpisodes");
		String w_streamedIn = resultSet.getString("streamedIn");
		String w_gener = resultSet.getString("gener");
		int w_yestAgeIndaNodbohudu = resultSet.getInt("yestAgeIndaNodbohudu");
		WebSeriesDTO dto = new WebSeriesDTO(name, w_noOfEpisodes, StreamedInType.valueOf(w_streamedIn),
				Genertype.valueOf(w_gener), w_yestAgeIndaNodbohudu);
		dto.setW_id(id);
		collection.add(dto);
	}

	@Override
	public Collection<WebSeriesDTO> findall(Predicate<WebSeriesDTO> predicate) {
		System.out.println("Find all data's from table");
		Collection<WebSeriesDTO> optional = new ArrayList<WebSeriesDTO>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "SELECT * FROM Webseries";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				WebSeriesDTO dto = createResultSet(resultSet);
				if (predicate.test(dto)) {
					optional.add(dto);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;

	}

	@Override
	public int total() {
		int value = 0;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			String count = "select * from webseries";

			Statement statement = connection.createStatement();
			statement.execute(count);
			ResultSet resultset = statement.getResultSet();
			int counts = 0;

			while (resultset.next()) {
				value = counts++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}

	@Override
	public Collection<WebSeriesDTO> findAllSortByNameDesc() {

		System.out.println("Find all data's from table name in decending order");
		Collection<WebSeriesDTO> collection = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "select * from webseries order by name desc";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				createDTOFromResultSetValues(collection, resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Optional<WebSeriesDTO> findone(Predicate<WebSeriesDTO> predicate) {

		System.out.println("Find all data's from table using Predicate");
		Optional<WebSeriesDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {
			String query = "SELECT * FROM Webseries";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				WebSeriesDTO dto = createResultSet(resultSet);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optional;
	}

	private WebSeriesDTO createResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		int w_noOfEpisodes = resultSet.getInt("noOfEpisodes");
		String w_streamedIn = resultSet.getString("streamedIn");
		String w_gener = resultSet.getString("gener");
		int w_yestAgeIndaNodbohudu = resultSet.getInt("yestAgeIndaNodbohudu");
		WebSeriesDTO dto = new WebSeriesDTO(name, w_noOfEpisodes, StreamedInType.valueOf(w_streamedIn),
				Genertype.valueOf(w_gener), w_yestAgeIndaNodbohudu);
		return dto;
	}

	@Override
	public int findMaxEpisodes() {

		int value = 0;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			String max = " select * from webseries where noOfEpisodes = (select max(noOfEpisodes) from webseries) ";

			PreparedStatement statement = connection.prepareStatement(max);
			statement.execute(max);
			ResultSet resultset = statement.getResultSet();

			if (resultset.next()) {
				value = resultset.getInt("noOfEpisodes");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}

	@Override
	public int findMinEpisodes() {
		int value = 0;
		try (Connection connection = DriverManager.getConnection(JDBCConstant.url, JDBCConstant.username,
				JDBCConstant.password)) {

			String max = " select * from webseries where noOfEpisodes = (select min(noOfEpisodes) from webseries) ";

			PreparedStatement statement = connection.prepareStatement(max);
			statement.execute(max);
			ResultSet resultset = statement.getResultSet();

			if (resultset.next()) {
				value = resultset.getInt("noOfEpisodes");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}
}
