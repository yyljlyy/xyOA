package cn.xxljlxx.xyOA.domain;

import java.util.Date;
import java.util.Set;
/**
 * 主题实体
 * @author zhaoqx
 *
 */
public class Topic {
	private Long id;
	private String title;//标题
	private String content;//内容
	private Date postTime;//主题的发表时间
	private String ip;//客户端ip
	private int deleted;//删除标志 1删除 0未删除
	private int type;//  0普通帖 1精华帖  2置顶帖
	private User author;// 作者
	private Set<Reply> replies;//当前主题对应的多个回复
	private Forum forum;//当前主题所在的版块
	private Date lastUpdateTime;// 最后更新时间
	private int replyCount;// 当前主题的回复数量
	private Reply lastReply;// 当前主题对应的最后一个回复
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	
}
