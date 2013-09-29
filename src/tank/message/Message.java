/**
 * 
 */
package tank.message;

import java.util.ArrayList;
import java.util.List;

import tank.Tank;

/**
 * @author 周大帅
 *
 * @email 463734522@qq.com
 * 2013年9月29日
 */
public class Message {
	private List<Tank> otherTankList;

	public List<Tank> getOtherTankList() {
		return otherTankList;
	}

	public void setOtherTankList(List<Tank> otherTankList) {
		this.otherTankList = otherTankList;
	}
	
	/**
	 * 
	 */
	public Message() {
		// TODO Auto-generated constructor stub
	    this.setOtherTankList(new ArrayList<Tank>());
	}

}
