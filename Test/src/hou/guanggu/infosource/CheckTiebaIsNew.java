//package hou.guanggu.infosource;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.MessageDigest;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Properties;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//
///**
// * @author houweitao
// * @date 2015年12月23日 上午9:50:51
// * @end 2015年12月23日11:06:51
// * @ps 处理这处理那好麻烦哎..检查docdb
// * http://my.oschina.net/u/147181/blog/306010
// * http://www.jb51.net/article/38471.htm
// */
//
//public class CheckTiebaIsNew {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Connection conn = ConnectionFactory.getInstance().makeConnection();
//		CheckTiebaIsNew check = new CheckTiebaIsNew();
//
////		System.out.println(check.MD5("http://tieba.baidu.com/p/4228207789"));
////		try {
////			System.out.println(check.checkIsNew(conn, "http://tieba.baidu.com/p/4228207789"));
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//
//		int count = 0;
//
//		try {
//			ArrayList<String> list = check.readXSL();
//			for (String str : list) {
//				if (str.contains("http")) {
//					if (check.checkIsNew(conn, str)) {
//						count++;
//						System.out.println(str + "," + true);
//					} else
//						System.out.println(str + "," + false);
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println(count);
//	}
//
//	ArrayList<String> readXSL() throws FileNotFoundException, IOException {
//		File file = new File("doc/未采集链接-12-22.xls");
//		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file));
//		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
//		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
//		ArrayList<String> ret = new ArrayList<>();
//
//		int rowstart = hssfSheet.getFirstRowNum();
//		int rowEnd = hssfSheet.getLastRowNum();
//		for (int i = rowstart; i <= rowEnd; i++) {
//			HSSFRow row = hssfSheet.getRow(i);
//			if (null == row)
//				continue;
//			int cellStart = row.getFirstCellNum();
//			int cellEnd = row.getLastCellNum();
//
//			for (int k = cellStart; k <= cellStart; k++) {
//				HSSFCell cell = row.getCell(k);
//				if (null == cell)
//					continue;
//				System.out.print("" + k + "  ");
//				//System.out.print("type:"+cell.getCellType());
//
//				ret.add((String) cell.getStringCellValue());
//
//				switch (cell.getCellType()) {
//				case HSSFCell.CELL_TYPE_NUMERIC: // 数字
//					System.out.print(cell.getNumericCellValue() + "   ");
//					break;
//				case HSSFCell.CELL_TYPE_STRING: // 字符串
//					System.out.print(cell.getStringCellValue() + "   ");
//					break;
//				case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
//					System.out.println(cell.getBooleanCellValue() + "   ");
//					break;
//				case HSSFCell.CELL_TYPE_FORMULA: // 公式
//					System.out.print(cell.getCellFormula() + "   ");
//					break;
//				case HSSFCell.CELL_TYPE_BLANK: // 空值
//					System.out.println(" ");
//					break;
//				case HSSFCell.CELL_TYPE_ERROR: // 故障
//					System.out.println(" ");
//					break;
//				default:
//					System.out.print("未知类型   ");
//					break;
//				}
//
//			}
//			System.out.print("\n");
//		}
//		return ret;
//	}
//
//	boolean checkIsNew(Connection conn, String url) throws SQLException {
//
//		PreparedStatement ps = conn.prepareStatement("SELECT * from wdyq_pages WHERE id = ?");
//		ps.setString(1, MD5(uniformURL(url)));
//		ResultSet rs = ps.executeQuery();
//		if (rs.next())
//			return true;
//		else
//			return false;
//	}
//
//	String uniformURL(String url) {
//		String[] arr = url.replace("?", "-").split("-");
////		System.out.println(arr[0]);
//		return arr[0];
//	}
//
//	public String MD5(String inStr) {
//		MessageDigest md5 = null;
//		try {
//			md5 = MessageDigest.getInstance("MD5");
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			e.printStackTrace();
//			return "";
//		}
//		char[] charArray = inStr.toCharArray();
//		byte[] byteArray = new byte[charArray.length];
//
//		for (int i = 0; i < charArray.length; i++)
//			byteArray[i] = (byte) charArray[i];
//
//		byte[] md5Bytes = md5.digest(byteArray);
//
//		StringBuffer hexValue = new StringBuffer();
//
//		for (int i = 0; i < md5Bytes.length; i++) {
//			int val = ((int) md5Bytes[i]) & 0xff;
//			if (val < 16)
//				hexValue.append("0");
//			hexValue.append(Integer.toHexString(val));
//		}
//
//		return hexValue.toString().toUpperCase();
//	}
//}
//
//class ConnectionFactory {
//	private static String driver = "com.mysql.jdbc.Driver";
//	private static String dburl = "jdbc:mysql://119.254.110.32:3001/docdb?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";
//	private static String user = "peony";
//	private static String password = "UdenTan#23851";
//
//	private static final ConnectionFactory factory = new ConnectionFactory();
//
//	private Connection conn;
//
//	private ConnectionFactory() {
//
//	}
//
//	public static ConnectionFactory getInstance() {
//		return factory;
//	}
//
//	public Connection makeConnection() {
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(dburl, user, password);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return conn;
//	}
//}
