package org.qunar.qst.qst.util;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by ronghaizheng on 15/3/3.
 */
public class FilePrintUtils {
    /* 打印指定的文件 */
    private void printFileAction()
    {
        // 构造一个文件选择器，默认为当前目录
        JFileChooser fileChooser = new JFileChooser();
        int state = 0;// 弹出文件选择对话框
        if (state == fileChooser.APPROVE_OPTION)// 如果用户选定了文件
        {
            File file = fileChooser.getSelectedFile();// 获取选择的文件
            // 构建打印请求属性集
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            // 设置打印格式，因为未确定文件类型，这里选择 AUTOSENSE
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            // 查找所有的可用打印服务
            PrintService printService[] =
                    PrintServiceLookup.lookupPrintServices(flavor, pras);
            // 定位默认的打印服务
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
            // 显示打印对话框
            PrintService service = ServiceUI.printDialog(null, 200, 200, printService
                    , defaultService, flavor, pras);
            if (service != null)
            {
                try
                {
                    DocPrintJob job = service.createPrintJob();// 创建打印作业
                    FileInputStream fis = new FileInputStream(file);// 构造待打印的文件流
                    DocAttributeSet das = new HashDocAttributeSet();
                    Doc doc = new SimpleDoc(fis, flavor, das);// 建立打印文件格式
                    job.print(doc, pras);// 进行文件的打印
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
