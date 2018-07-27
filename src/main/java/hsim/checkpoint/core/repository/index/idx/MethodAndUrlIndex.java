package hsim.checkpoint.core.repository.index.idx;

import hsim.checkpoint.core.domain.ValidationData;
import hsim.checkpoint.core.repository.index.util.ValidationIndexUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodAndUrlIndex implements ValidationDataIndex {

    Map<String, List<ValidationData>> indexMap = new HashMap<>();

    @Override
    public void refresh() {
        this.indexMap = new HashMap<>();
    }


    @Override
    public List<ValidationData> get(String key) {
        List<ValidationData> datas = this.indexMap.get(key);
        return datas == null ? new ArrayList<>() : datas;
    }

    @Override
    public String getKey(ValidationData data) {
        return ValidationIndexUtil.makeKey(data.getMethod(), data.getUrl());
    }

    @Override
    public Map<String, List<ValidationData>> getMap() {
        return this.indexMap;
    }
}
