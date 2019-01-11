package com.wgh.love.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andUseripIsNull() {
            addCriterion("userip is null");
            return (Criteria) this;
        }

        public Criteria andUseripIsNotNull() {
            addCriterion("userip is not null");
            return (Criteria) this;
        }

        public Criteria andUseripEqualTo(String value) {
            addCriterion("userip =", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotEqualTo(String value) {
            addCriterion("userip <>", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripGreaterThan(String value) {
            addCriterion("userip >", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripGreaterThanOrEqualTo(String value) {
            addCriterion("userip >=", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLessThan(String value) {
            addCriterion("userip <", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLessThanOrEqualTo(String value) {
            addCriterion("userip <=", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripLike(String value) {
            addCriterion("userip like", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotLike(String value) {
            addCriterion("userip not like", value, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripIn(List<String> values) {
            addCriterion("userip in", values, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotIn(List<String> values) {
            addCriterion("userip not in", values, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripBetween(String value1, String value2) {
            addCriterion("userip between", value1, value2, "userip");
            return (Criteria) this;
        }

        public Criteria andUseripNotBetween(String value1, String value2) {
            addCriterion("userip not between", value1, value2, "userip");
            return (Criteria) this;
        }

        public Criteria andUsersearchIsNull() {
            addCriterion("usersearch is null");
            return (Criteria) this;
        }

        public Criteria andUsersearchIsNotNull() {
            addCriterion("usersearch is not null");
            return (Criteria) this;
        }

        public Criteria andUsersearchEqualTo(String value) {
            addCriterion("usersearch =", value, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchNotEqualTo(String value) {
            addCriterion("usersearch <>", value, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchGreaterThan(String value) {
            addCriterion("usersearch >", value, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchGreaterThanOrEqualTo(String value) {
            addCriterion("usersearch >=", value, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchLessThan(String value) {
            addCriterion("usersearch <", value, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchLessThanOrEqualTo(String value) {
            addCriterion("usersearch <=", value, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchLike(String value) {
            addCriterion("usersearch like", value, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchNotLike(String value) {
            addCriterion("usersearch not like", value, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchIn(List<String> values) {
            addCriterion("usersearch in", values, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchNotIn(List<String> values) {
            addCriterion("usersearch not in", values, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchBetween(String value1, String value2) {
            addCriterion("usersearch between", value1, value2, "usersearch");
            return (Criteria) this;
        }

        public Criteria andUsersearchNotBetween(String value1, String value2) {
            addCriterion("usersearch not between", value1, value2, "usersearch");
            return (Criteria) this;
        }

        public Criteria andVisiturlIsNull() {
            addCriterion("visiturl is null");
            return (Criteria) this;
        }

        public Criteria andVisiturlIsNotNull() {
            addCriterion("visiturl is not null");
            return (Criteria) this;
        }

        public Criteria andVisiturlEqualTo(String value) {
            addCriterion("visiturl =", value, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlNotEqualTo(String value) {
            addCriterion("visiturl <>", value, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlGreaterThan(String value) {
            addCriterion("visiturl >", value, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlGreaterThanOrEqualTo(String value) {
            addCriterion("visiturl >=", value, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlLessThan(String value) {
            addCriterion("visiturl <", value, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlLessThanOrEqualTo(String value) {
            addCriterion("visiturl <=", value, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlLike(String value) {
            addCriterion("visiturl like", value, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlNotLike(String value) {
            addCriterion("visiturl not like", value, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlIn(List<String> values) {
            addCriterion("visiturl in", values, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlNotIn(List<String> values) {
            addCriterion("visiturl not in", values, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlBetween(String value1, String value2) {
            addCriterion("visiturl between", value1, value2, "visiturl");
            return (Criteria) this;
        }

        public Criteria andVisiturlNotBetween(String value1, String value2) {
            addCriterion("visiturl not between", value1, value2, "visiturl");
            return (Criteria) this;
        }

        public Criteria andFromurlIsNull() {
            addCriterion("fromurl is null");
            return (Criteria) this;
        }

        public Criteria andFromurlIsNotNull() {
            addCriterion("fromurl is not null");
            return (Criteria) this;
        }

        public Criteria andFromurlEqualTo(String value) {
            addCriterion("fromurl =", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlNotEqualTo(String value) {
            addCriterion("fromurl <>", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlGreaterThan(String value) {
            addCriterion("fromurl >", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlGreaterThanOrEqualTo(String value) {
            addCriterion("fromurl >=", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlLessThan(String value) {
            addCriterion("fromurl <", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlLessThanOrEqualTo(String value) {
            addCriterion("fromurl <=", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlLike(String value) {
            addCriterion("fromurl like", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlNotLike(String value) {
            addCriterion("fromurl not like", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlIn(List<String> values) {
            addCriterion("fromurl in", values, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlNotIn(List<String> values) {
            addCriterion("fromurl not in", values, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlBetween(String value1, String value2) {
            addCriterion("fromurl between", value1, value2, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlNotBetween(String value1, String value2) {
            addCriterion("fromurl not between", value1, value2, "fromurl");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creattime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creattime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creattime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creattime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creattime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creattime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creattime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creattime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creattime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creattime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creattime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creattime not between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}