// package hou.importNew;
//
/// **
// * @author houweitao 2015年9月25日 上午10:19:15
// *http://www.importnew.com/16670.html
// */
//
// public class DynamicProxiesTest {
//
// public static void main(String[] args) {
// // TODO Auto-generated method stub
//
// }
//
// public class Person {
//
// private String name;
// private int age;
//
// public String getName() {
// return name;
// }
//
// public void setName(String name) {
// this.name = name;
// }
//
// public int getAge() {
// return age;
// }
//
// public void setAge(int age) {
// this.age = age;
// }
//
// // insert getters and setters here
// }
//
// void assertThat(Person person, aPerson()
// .withName("Arthur Putey")
// .withAge(greaterThan(43))){}
//
// interface PersonMatcher extends Matcher<Person> {
// PersonMatcher withName(String expected);
// PersonMatcher withName(Matcher<? super String> matching);
// PersonMatcher withAge(int expected);
// PersonMatcher withAge(Matcher<Integer> matching);
// }
//
// static PersonMatcher aPerson() {
// return MagicMatcher.proxying(PersonMatcher.class);
// }
// }
