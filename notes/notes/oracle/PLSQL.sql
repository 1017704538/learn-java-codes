PLSQL�������

һʹ��PL/SQL��ӡhello world

ע�⣺�����Ҫ����Ļ�д�ӡ��Ϣ��Ҫserveroutput ���ش�

set serveroutput on;

declare
	--˵������
begin
	--����ʼ
	dbms_output.put_line('hello world');
end;


dbms_output.put_line��oracleΪ�����ṩ�ĳ������oracle���ṩ�˺ܶ������������Լ�ȥ���������
����sqlplus��ʹ�ã�desc dbms_output�鿴������Ľṹ



����ʲô��PL/SQL����

2.1PL/SQL��procedure Language/SQL��

PL/SQL��Oracle��sql���ԵĹ��̻���չ
ֻ��sql�������������� ���̻��������֧��ѭ������ʹ��SQL���Ծ��й��̴�������

PL/SQLͨ����SQL���Ե����ݲ���������������Ե����ݴ��������������ʹ��SQL��������������Ե�����

2.2��ͬ�����ݿ��SQL��չ
oracle:PL/SQL
DB2:SQL/PL
SQL Server:Transac-SQL��T-SQL��

����PL/SQL�ĳ���ṹ

3.1������PL/SQL�ṹ��

	declare
		˵�����֣�����˵�����������������˵����

	begin
		������У�DML��䣩

	exception
		���⴦�����
	end;


	���У�declare ��exception���û�п��Բ�д���ǷǱ���ĵ��Ǳ����� begin ��end

	
3.2˵�����֣�


3.2.1�����������

���ͣ�char ,varchar2,date,number,boolean,long
������
	var1 char(15);
	married boolean :=ture; --������ͬʱ��ʼ�� PL/SQL�и�ֵʹ�� :=
	pasl number(7,2);

������
declare
	--���������������
	pnumber number(7,2);
	pname varchar2(20);
	pdate date;
begin
	pnumber := 1;
	dbms_output.put_line(pnumber);

	pname := 'tom';
	dbms_output.put_line(pname);

	pdate := sysdate;
	dbms_output.put_line(pdate);
end;

�����
1
tom
12-10��-16


3.2.2����������� �������ͱ����ͼ�¼���� ����

�����ͱ�����
	my_name emp.ename%type
	��ʾ���� my_name ������Ϊ��emp����ename������һ��
	������

	declare
		--���������ͱ���
		pename emp.ename%type;
		psal  emp.sal%type;
	begin
		--�õ�Ա��7839��������нˮ
		select ename,sal into pename,psal from emp where empno=7839;
		dbms_output.put_line('Ա������:'||pename);
		dbms_output.put_line('Ա��нˮ:'||psal);
	end;

	ע�⣺1.plsql�и�ֵ�����ַ�ʽ����һ��Ϊ :=  �ڶ���ʹ��into �ؼ���ע�⣬into��ߵı���
		��Ҫ��ǰ�ߵĲ�ѯ���˳��һ��
	
	       2.select ename,sal into pename,psal from emp where empno=7839; ��ߵĸ�ֵ����:= ������ĸ�ֵ������
		



��¼�ͱ�����
	emp_rec emp%rowtype
	emp_rec��ʾ��¼�˱�empһ�е����ͣ�������Ϊ��һ�������¼��һ���е�ÿһ��

	������

	declare
		--�����¼�ͱ���
		emp_rec emp%rowtype;
	begin
		--�õ�Ա��7839��������нˮ
		select * into emp_rec from emp where empno=7839;
		dbms_output.put_line('Ա������:'||emp_rec.ename);
		dbms_output.put_line('Ա��нˮ:'||emp_rec.sal);
	end;


3.3�����е������

	3.3.1if���

	�﷨��
	1.
		if ���� then 
		���1��
		end if;

	2. 
		if ���� then
			���1��
		else 
			���2��
		end if;
	3.
		if ���� then
			���1��
		elsif ���� then
			���2��
			...
		elsif 
			���..��
		end if;

	����������һ���û��Ӽ�����������֣��ж�����

	/*
	�ж��û��Ӽ������������
	1.���ܼ�������
	2.���ʹ��if���
	*/

	set serveroutput on;
	--����һ����������
	--num��һ����ַֻ���ڸõ�ַ�б��������ֵ
	accept num prompt '������һ������'��

	declare
		--�������������������������
		pnum number := &num;

	begin
		--ִ�������ж����
		if pnum = 0 then
			dbms_output.put_line('�������������0');
		elsif pnum = 1 then
			dbms_output.put_line('�������������1');
		else
			dbms_output.put_line('��������');
			
		end if;
	end;

	

	3.3.2 3��ѭ�����

		1.whileѭ��

		while total <= 2500 loop

		...
		total :=total +10;
		end loop;

		������while��ӡ1����10

		declare
			--����ѭ������
			pnum number := 1;
		begin
			while pnum <=10 loop
				--ִ��ѭ����
				dbms_output.put_line(pnum);
				pnum := pnum +1; 
			end loop;
	end;

		ע�⣺pl/sql�в���ʹ��++ += --������


		2.loopѭ��,���ٻ�ִ��ѭ����һ��

		loop 
		exit [when ����]��
		....
		end loop;

		������loop��ӡ1����10

		declare
			--����ѭ������
			pnum number := 1;
		begin
			loop
				--�˳�����
				exit when pnum > 10;
				--û�дﵽ�˳�������ӡ
				dbms_output.put_line(pnum);
				pnum := pnum +1;
			end loop;
		 end;

		3.forѭ��
		for i in 1..10 loop
		�������
		end loop;

		������ʹ��forѭ����ӡ1����10

		declare
			--����ѭ������
			pnum number := 1;
		begin
			-- 1..10��ʾÿ��ȡ��һ����pnum����
			for pnum in 1..10 loop  
				dbms_output.put_line(pnum);
			end loop;
		 end;


3.4��������
	
	������һ���������Result Set

	�﷨��CURSOR �������[(������ ��������[������ ��������]...)]

	is select ��䣻

	��������ѯ����ӡԱ����нˮ

	/*
	1.�������� 4�� ���� %��ͷ
	%found-ȡ����¼  %notfound-û��ȡ����¼
	%isopen �жϹ���Ƿ��
	%rowcount Ӱ������������˵���ǹ�����ܹ���100����¼����ȡ��10����¼����ô%rowcountӦ����10������100

	*/
	
	declare
		--����һ�����,���Բ�������
		cursor cemp is select ename,sal from emp;
		--�������
		pename emp.ename%type;
		psal emp.sal%type;
	begin
		--�򿪹�� --�ر�ʹ��֮ǰ��Ҫ�򿪣�ʹ��������Ҫ�ر�
		open cemp;
		--�жϹ���Ƿ��
		if cemp%isopen then 
			dbms_output.put_line('������');
			
			--ѭ���ӹ����������ȡ������
			loop
				--ȡһ����¼,ʹ��fetch�ӹ����ȡ��һ����¼��֮���������ƶ�
				fetch cemp into peanme,psal;
				--ѭ���˳�û��ȡ����¼��ʱ��
				exit when cemp%notfound;
				--�����ӡ��¼
				dbms_output.put_line(pename||'нˮ��'||psal);
				--��ӡӰ������
				dbms_output.put_line(cemp%rowcount);
			end loop;

		else
			dbms_output.put_line('���û�д�');

		--�رչ��
		close cemp;

	end;




	�������ԣ�

	%found������ȡ������  %notfound ��겻��ȡ������
	%isopen �жϹ���Ƿ��
	%rowcount Ӱ������������˵���ǹ�����ܹ���100����¼����ȡ��10����¼����ô%rowcountӦ����10������100
	�������� Ĭ������� oracle���ݿ�ֻ������ͬһ���ػ��д�300�����
	��Щ��Ϣ���ǿ��������ݿ�Ĺ���Ա�û��в�ѯ��

	ͨ������Ա�û�����ִ����������
	
	show parameter abcd  --����൱������ģ����ѯ

	show parameter cursor --��ѯ������ز���

	cursor_sharing                       string
EXACT
cursor_space_for_time                boolean
FALSE
open_cursors                         integer
300
session_cached_cursors               integer
20


�޸�Ĭ�Ͽ��Դ򿪵Ĺ����

ͨ������Ա�û��޸�Ĭ�Ϲ��Ĵ�������
	alter system set open_cursors=4000 scope = both;
	scope��ȡֵ��both��memory(��ʾֻ���ĵ�ǰʵ���������Ĳ����ļ�),spfile(ֻ���Ĳ����ļ��������ĵ�ǰʵ������Ҫ��������������Ч)


3.5�������Ĺ��

	�����ʱ��
		�벻�������Ĺ���������Ƕ����ʱ�򣬿����趨�βκ�ʵ��
	�򿪵�ʱ��
		�������Ĺ��򿪵�ʱ����Ҫ����ʵ��

declare
	--����������Ĺ��  ������dno��Ϊ�β�                :=dno ��Ϊʵ��
	cursor cemp(dno number) is select ename from emp where deptno:=dno;

	--�������
	pename emp.ename%type;
begin

	--�򿪹���ʱ����Ҫ����һ��ʵ��  ����˵��Ҫ��ѯ10�Ų��ŵ�Ա������
	open cemp(10)��

		loop
			--ȡ��ÿ��Ա��������
			fetch cemp into pename;
			--û��ȡ����¼�˳�ѭ��
			exit where cemp%notfoun;
			--�����ӡԱ������
			dbms_output.put_line(pename);

		end loop;
	--�رչ��
	close cemp;
end;



3.6���⣬�쳣����

	oracle������������
		internally defined (ϵͳ����õ�����)
			���磺  No_data_found û���ҵ�����
				Too_many_rows ��select..into ���ƥ�����У�
				Zero_Divide(������)
				Value_error(������ת������)
				Timeout_on_resource(�ڵȴ���Դʱ������ʱ)
					����˵�ڷֲ�ʽ���ݿ���  һ�����ݿ��ڱ���    һ�����ݿ����Ϻ�  ���������ݿ�������Ϻ������ݿ�������ˣ��ܾö�û�еȵ��Ϻ�������
					���ҷ��ؽ�����ͻᷢ���������
				....
		user defined���Զ������⣩

	
	3.6.1ϵͳ���ⰸ����

	--ϵͳ���� û�з������� no_data_found
	declare
		pname emp.ename%type;
	begin
		--��ѯԱ��������1234��Ա��������(���粻���ڸ�Ա���ͻ��Ҳ�������)
		select ename into pename from emp where empno =1234;
	
	exception
		when no_data_found then
		dbms_output.put_line('û���ҵ���Ա��');
		when others then --�����ϱ�������ݿ���������������ﲶ�񣬱��⽫�����׸����ݿ�
		dbms_output.put_line('��������');
	end;

	
	�����û���ҵ���Ա��
	


	--ϵͳ���� ���ض����� Too_many_rows
	declare
		pname emp.ename%type;
	begin
		--��ѯ����10�Ų��ֵ�Ա��������
		select ename into pename from emp where deptno =10;
	
	exception
		when too_many_rows then
		dbms_output.put_line('ƥ���˶����');
		when others then --�����ϱ�������ݿ���������������ﲶ�񣬱��⽫�����׸����ݿ�
		dbms_output.put_line('��������');
	end

	�����ƥ���˶����

	--ϵͳ���� ����� Zero_Divide
	declare
		--����һ����������
		pnum number;
	begin
		pnum :=1/0;
	
	exception
		when zero_divide then
		dbms_output.put_line('0����������');
		when others then --�����ϱ�������ݿ���������������ﲶ�񣬱��⽫�����׸����ݿ�
		dbms_output.put_line('��������');
	end;
	
	�����0����������
	

	--ϵͳ���� ������ת������ value_error
	declare
		--����һ����������
		pnum number;
	begin
		pnum :='abc';
	
	exception
		when value_error then
		dbms_output.put_line('������ת������');
		when others then --�����ϱ�������ݿ���������������ﲶ�񣬱��⽫�����׸����ݿ�
		dbms_output.put_line('��������');
	end;
	
	�����������ת������	



3.6.2�Զ�������

	���������������exception 
	ʹ��raise�׳��Զ�������

	������

	declare 
		my_job char(20);
		v_sal emp.sal%type;
		--�Զ����쳣
		no_data exception;

		cursor c1 is select distinct job from emp order by job;

	begin
		open c1;
		fetch c1 into v_job;

		if c1%notfound then 
			--�׳��Զ����쳣
			raise no_data;
		end if;

		close c1;

	exception

		when no_data then  --�����Զ����쳣
		dbms_output.put_line('û�з�������');
		when others then --�����ϱ�������ݿ���������������ﲶ�񣬱��⽫�����׸����ݿ�
		dbms_output.put_line('��������');
	end;


�����ܽ᣺ �����Ƚϸ��ӵ�PL/SQL��

1.˵��
	1.�±ߵ�for emm in (select * from newqdgl.agent_point_not_user_sql) loop .. end loop; ��forѭ������ѯ���
		���ϱ��浽emm��ʱ�����У��������cursor�Ĺ���

	2.oracle��ѭ������ڽϵ͵İ汾����break��ʾ��������ѭ��������û��continue��������ѭ���Ĺ��ܣ����ǿ���ͨ��
		goto����ӵ�ʵ��continue���� ���¶���������<<endlabel>> ��ʹ��goto endlabel;�Ϳ�����ת��������

	3.�������������
		ǰ�������õĶ��������飬�����������﷨ <<����>>


declare
  v_OpId         number(12);
  v_Org_Id       number(12);
  v_llCountMonth number(12); --��ʾ������Ҫ���ֳ��˵��·�
  v_iChangePoint number(12); --��ʾת������
  v_pointsSysId  number(12); --���ֱ��
  v_lPointsValue number(12); --ת��������ʱ����
  v_sql          varchar2(1024);

  v_thisyearValuedPoints number(12); --�����ӱ���Ȼ���
  v_CurrPoints           number(12); --�����ӱ�ǰ����
  v_docode               number(12); --��ȡҵ���¼
  v_doneCode            number(12);
  v_subdtail_CurrPoints number(12); --������ϸ��ǰ����
  v_POINTS_INFO_count   number(2);

begin
  v_OpId                := 999;
  v_Org_Id              := 999;
  v_llCountMonth        := 201608;
  v_iChangePoint        := 0;
  v_pointsSysId         := 0;
  v_lPointsValue        := 0;
  v_subdtail_CurrPoints := 0;
  v_POINTS_INFO_count   :=0;

  -- ͨ���±�����forѭ���ķ�ʽ�����Խ���ѯ������ϱ��浽һ����ʱ���ϱ����У����Դﵽ�����ڹ��cursor��Ч��
  for emm in (select * from newqdgl.agent_point_not_user_sql) loop
  
    dbms_output.put_line('1---' || emm.agent_id || '--' ||emm.curr_point_not_exc);
  
    -- 3.���ֱ��
    --���ݴ����̱�Ų�ѯ��Ӧ���ֱַ���
    
    select count(1) into v_POINTS_INFO_count from 
    newqdgl.POINTS_INFO
     WHERE 1 = 1
       AND POINTS_ID = emm.agent_id;
     if v_POINTS_INFO_count =0 then
       goto endlabel;
      end if;
       
    SELECT POINTS_SYS_ID
      into v_pointsSysId
      FROM newqdgl.POINTS_INFO
     WHERE 1 = 1
       AND POINTS_ID = emm.agent_id;
  
    dbms_output.put_line('2---'||v_pointsSysId);
  
    -- 3.1 ����  ���ɶһ�ת������  == �ɶһ���������
    if mod(v_llCountMonth, 100) = 1 then
      v_iChangePoint := emm.curr_point_not_exc;
    else
      v_iChangePoint := emm.curr_point_not_exc /
                        (14 - mod(v_llCountMonth, 100));
    end if;
    dbms_output.put_line('3----'||v_pointsSysId||'---'||v_iChangePoint);
  
    --3.2����AGENT_POINT_NOT_USER ���еĲ��ɶһ�����
    UPDATE newqdgl.AGENT_POINT_NOT_USER
       set CURR_POINT_NOT_EXC =
           (emm.curr_point_not_exc - v_iChangePoint),
           REC_STATUS         = 1
     WHERE AGENT_ID = emm.agent_id;
  
    --3.3 �����ǳ��ֻ���
  
    v_lPointsValue := v_iChangePoint;
  
    --3.4��������addAgentCurrPoint(pointsSysId, agentId, lPointsValue, llCountMonth);
  
    dbms_output.put_line('����������ʼ' || v_pointsSysId || '---' ||emm.agent_id);
    --3.4.1��ѯ�����ӱ��е���Ϣ
    SELECT CURR_POINTS, THISYEAR_VALUED_POINTS
      into v_CurrPoints, v_thisyearValuedPoints
      FROM newqdgl.ods_points_subinfo
     WHERE 1 = 1
       AND POINTS_SYS_ID = v_pointsSysId
       AND POINTS_ID = emm.agent_id;
  
    dbms_output.put_line('4----');
  
    -- 2.4.2��������ӱ��¼����ʱ��
    insert into ods_points_subinfo_temp
      (POINTS_SYS_ID,
       POINTS_ID_TYPE,
       POINTS_ID,
       CURR_POINTS,
       THISYEAR_VALUED_POINTS)
    values
      (v_pointsSysId,
       4,
       emm.agent_id,
       (v_CurrPoints + v_lPointsValue),
       (v_thisyearValuedPoints + v_lPointsValue));
  
    dbms_output.put_line('5----');
  
    --3.4.3��ѯ������ϸ
    SELECT POINTS_SYS_ID SUB_CURR_POINTS
      into v_subdtail_CurrPoints
      FROM points_info_detail_info
     WHERE 1 = 1
       AND POINTS_ID = emm.agent_id
       AND POINTS_ID_TYPE = 4
       AND POINTS_SYS_ID = v_pointsSysId
       AND POINTS_SUB_TYPE = 1;
  
    dbms_output.put_line('6----');
  
    --3.4.4���������ϸ����ʱ��
    insert into points_info_detail_info_temp
      (POINTS_SYS_ID,
       POINTS_ID_TYPE,
       POINTS_ID,
       POINTS_SUB_TYPE,
       SUB_CURR_POINTS)
    values
      (v_pointsSysId,
       4,
       emm.agent_id,
       1,
       (v_subdtail_CurrPoints + v_lPointsValue));
  
    dbms_output.put_line('7----');
  
    --3.4.5 ��ȡҵ���¼����
    SELECT newqdgl.SEQ_DONE_NEW_CODE.NEXTVAL into v_docode FROM DUAL;
  
    INSERT INTO points_subcount_info_temp
      (points_sys_id,
       points_id_type,
       points_id,
       get_sub_points,
       points_sub_type,
       done_code)
    VALUES
      (v_pointsSysId, 4, emm.agent_id, v_lPointsValue, 1, v_docode);
  
  
    dbms_output.put_line('8----' || v_CurrPoints || '--' ||v_thisyearValuedPoints || '--' || v_lPointsValue || '--' ||v_llCountMonth);
  
    insert into ods_points_count_temp
      (points_sys_id,
       points_id_type,
       points_id,
       get_points,
       points_busi_code,
       done_date,
       done_code,
       bill_month,
       op_id,
       curr_points,
       thisyear_valued_points,
       ext4)
    values
      (v_pointsSysId,
       4,
       emm.agent_id,
       v_lPointsValue,
       19,
       to_date('20160805', 'yyyymmdd'),
       v_docode,
       v_llCountMonth,
       9,
       (v_CurrPoints + v_lPointsValue),
       (v_thisyearValuedPoints + v_lPointsValue),
       to_char(v_CurrPoints + v_lPointsValue));
  
    dbms_output.put_line('������������' || v_pointsSysId || '---' ||emm.agent_id);
  
    select newqdgl.SEQ_DONE_CODE.nextval into v_doneCode from dual;
    --������ּ�¼
    insert into newqdgl.Channel_Point_Record_Ext
      (Chanenel_Entity_Id,
       Operate_Code,
       Oper_Value,
       Done_Code,
       Done_Date,
       Org_Id,
       Op_Id)
    values
      (emm.agent_id,
       8020311,
       0 - v_iChangePoint,
       v_doneCode,
       to_date('20160805', 'YYYY/MM/DD'), --����д�ɾ���ĳ�������
       v_Org_Id,
       v_OpId);
  
    dbms_output.put_line('9----');
  
    insert into newqdgl.Channel_Point_Record_Ext
      (Chanenel_Entity_Id,
       Operate_Code,
       Oper_Value,
       Done_Code,
       Done_Date,
       Org_Id,
       Op_Id)
    values
      (emm.agent_id,
       8020310,
       v_iChangePoint,
       v_doneCode,
       to_date('20160805', 'YYYY/MM/DD'), ----����д�ɾ���ĳ�������
       v_Org_Id,
       v_OpId);
  
  
    dbms_output.put_line('10----');
    
    <<endlabel>> --�����൱�ڶ�����һ�������ĵĿ飬endlabel ��ʹ��goto endlabel ��������goto endlabel ��endlabel֮��Ĵ���
		--������forѭ������󣬱��൱��ʵ����continue,��������󣬲���ʲô��ҪЩnull;
    null;
  end loop;
  --commit;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    dbms_output.put_line('error');
    RETURN;
end;



2.�±ߵķ�ʽ��̬��ƴ�ӳ�sql

	ʹ�� execute immediate v_sql; ��������ִ��ƴ�Ӻ��sql,ͬʱ����Ҳ����ʹ�������佫���ɺ��sql��ӡ������


//------------------3.�л��û���"aicbs"  ����ʱ���е����ݲ��뵽�����ֱ�--------------------------
-- 1. ods_points_count_temp
declare
       v_sql varchar2(1024);
begin
  for i in 0 .. 9 loop
     v_sql:='insert into aicbs.points_count0'||i||'_2016  select * from newqdgl.ods_points_count_temp where mod(points_sys_id,10) = '||i;
       execute immediate v_sql;
  end loop;
  --commit;
  EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    dbms_output.put_line('error');
    RETURN;
end;





4.�洢���̺ʹ洢����
	
	�洢���̺ʹ洢����������֪���ı���ͼ�����������С�ͬ��ʵ�һ�������������еĶ���

4.1ʲô�Ǵ洢���̺ʹ洢������
	ָ�洢�����ݿ��й����е��û�������õ� �ӳ���д洢���̡��洢������

	�洢���̺ʹ洢��������ͬ�㣺����ض����ܵĳ���
	�洢���̺ʹ洢�����������Ƿ���return ��䷵��ֵ���洢���̲���ʹ��return ����һ��������ֵ���洢�������ԣ�����������
	������Ϊ��������ͬ�ġ�

4.2������ʹ�ô洢����
	
	ʹ��create procedure������洢���̺ʹ洢����
	�﷨��
	--�������滻һ���洢����              �����б���Ҫָ����������������
	create [or replace] procedure ��������Name in out type, Name in out type, ...��
	as | is --�൱��PL/SQL���declare�����ﲻ��ʡ��
	PLSQL�ӳ����壻


	4.2.1���������Ĵ洢����

	--��һ���洢���̴�ӡhelloworld --ע�ⲻ�������Ĵ洢���̹�����������()
	create or replace procedure sayhelloWorld
	as 
	--�൱��PL/SQL��declare˵�����֣��������Ｔʹû��˵������Ҳ��Ҫд
	begin
		dbms_output.put_line('helloWorld');
	end sayhelloWorld;

	���ʹ��PL/SQL Developer ���ߣ���������ߵ�procedure���򿴵�����ִ�к�����Ĵ洢����

	4.2.2���ô洢����

		
		��ʽһ���� Command Windows���������ִ�У� exec sayhelloWorld();

		SQL> set serveroutput on;
		SQL> exec sayhelloworld(); 
		�����
			helloWorld
		��ʽ����������SQL Windows�� Command Windowsz��ִ��PL/SQL����
			begin
				sayhelloWorld();
			end;
		�����
			helloWorld
	
	4.2.2�������Ĵ洢����
		--����һ���������Ĵ洢���̣���ָ����Ա����100Ա���ʣ�����ӡ��ǰ���Ǻ��нˮ
		--in��ʾ��һ������������������������Ҫָ����������������������
		create or repalce procedure raisesalary(eno in number) 
		as
			--����һ������������ǰ��нˮ
			psal emp.sal%type;
		begin
			--�õ�Ա������ǰ��нˮ
			select sal into psal emp where empno=eno;
			--��Ա����100
			update emp set sal = sal+100 where empno = eno;
			--���������update,��������һ�㲻�ڴ洢���̺ʹ洢�����н����ύ����һ���ɵ����߽����ύ

			--��ӡ��ǰ���Ǻ��нˮ
			dbms_output.put_line('��ǰ:'||psal||'�Ǻ�'||(psal+100));
		end;


		����
			begin
				raisesalary(7839); --��Ա����Ϊ7839�ǹ���
				raisesalary(7566); --��Ա����Ϊ7566�ǹ���
			end;

		
		�洢������Debug����
			��ͼ



4.3�洢����
	
	������Function�� Ϊһ�����Ĵ洢���򣬿ɴ�������������һ����ֵ
	�����͹��̽ṹ���ƣ�������Ҫ��һ��return�Ӿ䣬���ڷ��غ�����ֵ��


	�����洢�������﷨��

	--�������Ĵ洢��������ָ�������б���������������������
	--���粻�����������ܴ�����
	create or replace function ��������Name in out type, Name in out type, ...��
	return ����ֵ����
	as | is
	PL/SQL�ӳ����壻

	������
		--�洢��������ѯĳ��Ա����������
		create or replace function queryempincomme(eno in number)
		return number
		as
			--�����������Ա����нˮ�ͽ���
			psal emp.sal%type;
			pcomm emp.comm%type;

		begin
			--�õ�Ա������н�ͽ���
			select sal,comm into psal,pcomm from emp where empno=eno;
			--ֱ�ӷ���������
			return psal*12+nvl(pcomm,0);
		end;

		����
		
		declare
			ypsal number;
		begin
			--�õ�Ա��7891��������
			ypsal:=queryempincomme(7891);
			dbms_output.put_line(ypsal);

		end;

4.4in��out ����

	ǰ�����ǽ����˴洢���̺ʹ洢����
	a.һ���������洢���̺ʹ洢�������������ڴ洢����������һ������ֵ�����洢����û�з���ֵ
	b.����洢���̻�洢�����������Ļ�������Ҫָ����������������������
	c.�洢���̺ʹ洢����������ͨ��out����ָ��һ������������������ǿ�������out�������ڹ��̻�����ʵ�ַ���һ������ֵ
	  �����洢���̱��������з���ֵ��������out���������ǾͿ���ʵ�ִ洢���̷���ֵ��
	d.һ�������Ҫ���ض��ֵ����������ʹ�ô洢���̣����ֻҪ����һ��ֵ��������ʹ�ô洢����


	������
	--����out������ѯԱ������������н��ְλ
	create or replace procedure queryempinfo(eno in number,pename out varchar2,psal out nubmer,pjob out varchar2)

	as
	begin
		--�õ�Ա������������н��ְλ
		select ename,sal,empjob into pename,psal,pjob from emp where empno=eno;

	end;

	���ã�

	declare 

		eno number;
		pename varchar2(30);
		psal number;
		pjob varchar2(200);

	begin
		eno := 7839;
		--���ô洢���̣����ǿ��Եõ�out�����ķ���ֵ
		queryempinfo(eno,pename,psal,pjob);

		dbms_output.put_line(pename);
		dbms_output.put_line(psal);
		dbms_output.put_line(pjob);
	end;


	���⣺�ϱߵİ���ֻ����out����������Ա���Ĳ�����Ϣ
		1.������Ҫ��ѯԱ����������Ϣ��out�����кܶ࣬�ѵ�Ҫд�ܶ��out������
		2.��ѯĳ������������Ա����������Ϣ---��out�з���һ������





5.�����

	��out������ʹ�ù��������Ҫʹ�õ���������Ҳ��oracle�е����ݿ����
	oracle�еİ���Ϊ��ͷ�Ͱ��壬��ͷ�������������帺��ʵ�֣��ߺ���java�еĽӿ���ʵ����Ĺ�ϵ��

	��ͷ�﷨��
	create [or replace] package package_name
	is | as
	--���幫�ó������������αꡢ����
	--���幫�õĹ��̺ͺ���
	end package_name;

	�����﷨

	create [or replace] package body package_name
	is | as
	--����˽�г��������������͡��αꡢ���̺ͺ���
	--ʵ�ֹ��õĹ��̺ͺ���
	end package_name


	��������ѯĳ������������Ա����������Ϣ,����ʹ�����·�����ʵ�ֵ�4�����µļ�������out�����ܶ���Ȼ����ȡ��������ʹ��cursor���ʵ��

	������ͷ
		create or replace package mypackage as 
		--���幫�õ����� �Զ�������empcursor Ϊ cursor����
		type empcursor is ref cursor;
		--���幫�õĹ��̺ͺ��� --֮����Ҫ�ڰ�����ʵ��
		procedure queryEmpList(dno in number,empList out empcursor);

		end mypackage;
	��������
		create or replace package body mypackage
		as

			procedure queryEmpList(dno in number,empList out empcursor)
			as
			begin
				--�򿪹��
				open empcursor from select * from emp where deptno=dno;
			end queryEmpList;
		end mypackage;

			


	���ó������
		���ù��ñ���
		exec �������.���ñ����� := ��ֵ��
		���ù��������ظ�
		exec �������.���ù�����(����)��






