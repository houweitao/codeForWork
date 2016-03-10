package hou.oschina.single;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * @author houweitao
 * @date 2016年1月1日 下午12:55:59
 * not word?
 * http://www.oschina.net/code/snippet_1777045_53294
 */

public class GetIPAdress {

	public static void main(String[] args) throws SocketException {
		Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		while (en.hasMoreElements()) {
			NetworkInterface ni = en.nextElement();
			// System.out.println(ni);
			printParameter(ni);
		}
	}

	public static void printParameter(NetworkInterface ni) throws SocketException {

		String name = ni.getDisplayName();
		if (name.contains("Adapter") || name.contains("Virtual") || name.contains("VMnet") || name.contains("#")) {
			return;
		}
		if (ni.isLoopback() || ni.isVirtual() || !ni.isUp() || !ni.supportsMulticast()) {
			return;
		}
		Formatter formatter = new Formatter();
		String sMAC = null;
		byte[] macBuf = ni.getHardwareAddress();
		if (macBuf != null) {
			for (int i = 0; i < macBuf.length; i++) {
				sMAC = formatter.format(Locale.getDefault(), "%02X%s", macBuf[i], (i < macBuf.length - 1) ? "-" : "")
						.toString();
			}
			formatter.close();
		}

		List<InterfaceAddress> list = ni.getInterfaceAddresses();
		Iterator<InterfaceAddress> it = list.iterator();
		while (it.hasNext()) {
			InterfaceAddress ifa = it.next();
			InetAddress ia = ifa.getAddress();
			if (ia.isSiteLocalAddress()) {
				System.out.println(" name = " + name);
				System.out.println(" ip = " + ia.getHostAddress());
				System.out.println(
						" Broadcast = " + (ifa.getBroadcast() == null ? "" : ifa.getBroadcast().getHostAddress()));
				System.out.println(" sMAC = " + sMAC);
				System.out.println(" submask = " + calcMaskByPrefixLength(ifa.getNetworkPrefixLength()));
			}
		}
		System.out.println("==================================");
	}

	public static String calcMaskByPrefixLength(int length) {
		int mask = -1 << (32 - length);
		int partsNum = 4;
		int bitsOfPart = 8;
		int maskParts[] = new int[partsNum];
		int selector = 0x000000ff;
		for (int i = 0; i < maskParts.length; i++) {
			int pos = maskParts.length - 1 - i;
			maskParts[pos] = (mask >> (i * bitsOfPart)) & selector;
		}
		String result = "";
		result = result + maskParts[0];
		for (int i = 1; i < maskParts.length; i++) {
			result = result + "." + maskParts[i];
		}
		return result;
	}

}
