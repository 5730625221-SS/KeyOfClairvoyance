package Render;

import java.util.ArrayList;
import java.util.List;

public class LeftRenderObj {

	public static final LeftRenderObj instance = new LeftRenderObj();
	public List<Renderable> entities;

	public static LeftRenderObj getInstance() {
		return instance;
	}

	public LeftRenderObj() {
		entities = new ArrayList<Renderable>();
	}

	public void add(Renderable entity) {
		entities.add(entity);
	}

	public List<Renderable> getRenderableList() {
		return entities;
	}

}
