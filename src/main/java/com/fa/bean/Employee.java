package com.fa.bean;

	public class Employee {
		
		public String empId;
		public String empName;
		
		public String getEmpId() {
			return empId;
		}
		public void setEmpId(String empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		//
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + "]";
		}
		
		

	
}
