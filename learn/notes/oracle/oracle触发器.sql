Oracle������

1.ʲô�Ǵ�����
	���ݿⴥ������һ�����������ģ������PL/SQL����
	ÿ��һ���ض��Ĳ�����䣨insert,update,delete����ָ���ı��Ϸ���ʱ��oracle�Զ�
	ִ�д����ж����������С�--ע��û��select


	1.��δ���������
	������ÿ��������Ա�����Զ���ӡ���ɹ�������Ա���������������ʣ�trigger��


	create or replace trigger saynewemp
	after insert --afterָ���ڲ���֮�󴥷���������beforeָ���ڲ���֮ǰ����������
	on emp 
	declare
	begin
		dbms_output.put_line('�ɹ�������Ա��');
	end;

	�����
	SQL> insert into emp(empno,ename,sal,deptno) values(1001,'Tom',3000,10);
	�ɹ�������Ա��
	�Ѵ���1��
	
	

2.��������Ӧ�ó���
	1.���ӵİ�ȫ�Լ��
	2.����ȷ��
	3.ʵ��������ƹ���
	4.������ݵı��ݺ�ͬ��

3.���������﷨
	create [or replace] trigger ��������
	{before | after} --�����Ǵ��������ڲ���ǰ���ǲ�������Ч
	{delete|insert|update[of����]}--������֧�ֵĲ�����update����ָ��ĳ��ִ�в���ʱ����
	on ���� --Ϊĳ�����������Ĵ�����
	[for each row[when(����)]] --����������൱���м���������Ĭ��Ϊ��伶������
	PLSQL��

4.������������
	��伶����������Ե��Ǳ�
		��ָ���Ĳ���������֮ǰ��֮��ִ��һ�Σ�ִֻ��һ�Σ�����˵���������������Ӱ���˶����С�
	�м�����������Ե�����
		����������õ�ÿһ����¼�������������м���������ʹ��:old��:newα��¼������ʶ��ֻ��״̬
		

	���磺�����Ҷ�����һ����伶������������10�Ų��ŵ�Ա������3����¼������emp10�У�������ֻ�ᴥ��һ��
	insert into emp10 select * from emp where deptno=10;
	     �����Ҷ�����һ���м�������������10�Ų��ŵ�Ա������3����¼������emp10�У�������ֻ�ᴥ������
		insert into emp10 select * from emp where deptno=10;



		

5.����
	
	--1.���ӵİ�ȫ�Լ��
	--��ֹ�ڷǹ����ڼ������Ա��
	/*
		1.��ĩ��to_char(sysdate,'day') in ('������','������')
		2.�ϰ�ǰ���°��to_number(to_char(sysdate,'hh24')) not betwwn 9 and 18
	*/

	create or replace trigger securityemp
	before insert --�ڲ���ǰ���м��
	on emp
	begin
		if to_char(sysdate,'day') in ('������','������') or 
		to_number(to_char(sysdate,'hh24')) not betwwn 9 and 18 then

			--��ֹ����Ա��,�׳��쳣��ʹ�����·�ʽ
			raise_application_error(-20001,'��ֹ�ڷǹ���ʱ�������Ա��');
			--����ֱ��ʹ��raise�׳��쳣��Ӧ��ʹ���ϱ����ַ�ʽ����һ��������ȡֵ -20000 ~ -29999
			--�ڶ����������������׳��쳣����ʾ������
		end if;

	end;

	����ڷǹ���ʱ��ִ��insert���ͻᴥ��������������ֹ�ڷǹ���ʱ�������Ա��
	
	--2.����ȷ��

	/*
	����������������ȷ��
	�Ǻ��нˮ���ܵ�����ǰ��нˮ

	1. :old �� :new ����ͬһ����¼
	2. :old��ʾ��������֮ǰ�ļ�¼
	   :new��ʾ��������֮��ļ�¼
	*/

	create or replace trigger checksalary
	before update
	on emp
	for each row --�м�������
	begin
		--if �Ǻ��нˮ < ��ǰ��нˮ
		if :new.sal < :old.sal then
			raise_application_error(-20002,'�Ǻ��нˮ����������ǰ��нˮ����ǰ��нˮ'||:new.sal||'�Ǻ��нˮ'||:old.sal);
		end if;
	end;
	
	update emp set sal=sal-1 where empno=7389; --����ᴥ��������

	3.ʵ��������ƹ���


	/*
	������Ӧ�ó�����.ʵ��������ƹ���====������ֵ�����
	��Ա���ǹ��ʣ����Ǻ�Ĺ�������6000��ʱ����Ƹ�Ա������Ϣ
	*/

	--�������������Ϣ
	create table audit_info(
		infomation varchar2(2000);
	);

	create or replace trigger do_audit_emp_salary
	after update
	on emp
	for each row
	begin
		--��Ա���Ĺ��ʴ���6000���������Ϣ
		if :new.sal>6000 then
			insert into audit_info values(:new.empno||' '||:new.ename||' '||:new.sal);
		end if;
	end;
	
	��ÿ��Ա���ǹ���2000,�������Ա�����ʴ���6000�ͻ������Ʊ�
	update emp set sal = sal+2000;

	4.������ݵı��ݺ�ͬ��

	/*
	���ô�����ʵ�����ݵ�ͬ���ͱ���----��ͬ������
	����A��Ϊ����B��Ϊ���ݱ����A���е����ݷ����仯����ͬ����B��
	��Ա�����깤�ʺ��Զ������µĹ��ʵ����ݱ���
	*/
	create or replace trigger sync_salary
	after update
	on emp
	for each row
	begin
		--��������º��Զ����б���
		update emp_back set sal = :new.sal where empno= :new.empno;
	end;

	update emp set sal=sal+10 where empno=7839;

	oracle�л��и����ÿ��ձ��ݣ����첽�ġ� �����ô���������ͬ���ġ�


	���ձ�������
	http://nakupanda.iteye.com/blog/1028819