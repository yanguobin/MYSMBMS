package cn.smbms.dao.provider;

import cn.smbms.pojo.Provider;

import java.util.List;

public interface ProviderMapper {
    /**
     * 查询供应商表记录数
     * @return
     */
    public int countProvider();
    /**
     * 查询供应商列表
     * @return
     */
    public List<Provider> getProviderList();

}
